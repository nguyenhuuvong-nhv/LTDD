package com.example.bt_sqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.bt_sqlite.data.Database;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Add extends AppCompatActivity {
    final String DATABASE_NAME="StudentDB.sqlite";
    final int RESQUEST_TAKE_PHOTO=123;
    final int RESQUEST_CHOOSE_PHOTO= 321;

    Button btChon, btChup, btLuu, btHuy;
    EditText txtTen, txtSdt, txtEmail, txtKhoahoc;
    ImageView Anh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        addControl();
        addEvents();
    }

    private void addControl() {
        btChon = (Button) findViewById(R.id.bt_chon);
        btChup = (Button) findViewById(R.id.bt_chup);
        btLuu = (Button) findViewById(R.id.bt_luuadd);
        btHuy = (Button) findViewById(R.id.bt_huyadd);
        txtTen = (EditText) findViewById(R.id.txt_tenadd);
        txtSdt = (EditText) findViewById(R.id.txt_Sdtadd);
        txtEmail = (EditText) findViewById(R.id.txt_Emailadd);
        txtKhoahoc = (EditText) findViewById(R.id.txt_khoahocadd);
        Anh = (ImageView) findViewById(R.id.imgAnhadd);


    }
    private void addEvents(){
        btChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePicture();
            }
        });
        btChup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
        btLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        btHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

    }
    private void takePicture(){
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, RESQUEST_TAKE_PHOTO);
    }
    private void choosePicture(){
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, RESQUEST_CHOOSE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RESQUEST_CHOOSE_PHOTO) {
                try {
                    Uri imageUri = data.getData();
                    InputStream is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    Anh.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            } else if (requestCode == RESQUEST_TAKE_PHOTO) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Anh.setImageBitmap(bitmap);
            }
        }
    }

    private void insert(){
        String ten = txtTen.getText().toString();
        String sdt = txtSdt.getText().toString();
        String email = txtEmail.getText().toString();
        String khoahoc = txtKhoahoc.getText().toString();

        byte[] anh= getByteArrayFromImageView(Anh);
        ContentValues contentValues =new ContentValues();
        contentValues.put("Ten",ten);
        contentValues.put("Sdt",sdt);
        contentValues.put("Email",email);
        contentValues.put("Khoahoc",khoahoc);
        contentValues.put("Anh",anh);

        SQLiteDatabase database=Database.initDatabase(this,"StudentDB.sqlite");
        database.insert("SinhVien",null,contentValues);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    private void cancel(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private byte[] getByteArrayFromImageView(ImageView imgv){

        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}