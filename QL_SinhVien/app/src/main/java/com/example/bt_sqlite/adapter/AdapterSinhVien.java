package com.example.bt_sqlite.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bt_sqlite.R;
import com.example.bt_sqlite.Update;
import com.example.bt_sqlite.data.Database;
import com.example.bt_sqlite.model.SinhVien;

import java.util.ArrayList;

public class AdapterSinhVien extends BaseAdapter {
    Activity context;
    ArrayList<SinhVien> list;

    public AdapterSinhVien(Activity context, ArrayList<SinhVien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.lv_row,null);

        ImageView imgAnh = row.findViewById(R.id.imgAnh);
        TextView txtTen= row.findViewById(R.id.txtTen);
        TextView txtSdt= row.findViewById(R.id.txtSdt);
        TextView txtEmail= row.findViewById(R.id.txtEmail);
        TextView txtKhoahoc= row.findViewById(R.id.txtKhoahoc);
        Button btSua= (Button) row.findViewById(R.id.bt_Sua);
        Button btXoa= (Button) row.findViewById(R.id.bt_Xoa);

        final SinhVien sinhVien = list.get(position);
        txtTen.setText(sinhVien.Ten);
        txtSdt.setText(sinhVien.Sdt);
        txtEmail.setText(sinhVien.Email);
        txtKhoahoc.setText(sinhVien.KhoaHoc);

        Bitmap bmAnh= BitmapFactory.decodeByteArray(sinhVien.Anh,0,sinhVien.Anh.length);
        imgAnh.setImageBitmap(bmAnh);

        btSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("ID",sinhVien.ID);
                context.startActivity(intent);
            }
        });
        btXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc muốn xóa sinh viên này không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delete(sinhVien.ID);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alertDialog= builder.create();
                builder.show();
            }
        });


        return row;
    }
    private void delete(int idSV){
        SQLiteDatabase database= Database.initDatabase(context,"StudentDB.sqlite");
        database.delete("SinhVien","ID = ?",new String[]{idSV+""});
        list.clear();
        Cursor cursor= database.rawQuery("SELECT * FROM SinhVien", null);
        while (cursor.moveToNext()){
            int ID= cursor.getInt(0);
            String ten = cursor.getString(1);
            String sdt = cursor.getString(2);
            String email = cursor.getString(3);
            String khoahoc = cursor.getString(4);
            byte[] anh= cursor.getBlob(5);
            list.add(new SinhVien(ID,ten,sdt,email,khoahoc,anh));
        }
        notifyDataSetChanged();

    }

}
