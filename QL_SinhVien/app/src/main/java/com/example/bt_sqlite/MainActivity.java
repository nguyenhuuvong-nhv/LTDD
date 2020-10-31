package com.example.bt_sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bt_sqlite.adapter.AdapterSinhVien;
import com.example.bt_sqlite.data.Database;
import com.example.bt_sqlite.model.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME="StudentDB.sqlite";
    SQLiteDatabase database;
    ListView listView;
    ArrayList<SinhVien> list;
    AdapterSinhVien adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addControls();
        readData();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        registerForContextMenu(listView);

    }

    private void addControls() {
        listView= (ListView) findViewById(R.id.listView);
        list= new ArrayList<>();
        adapter= new AdapterSinhVien(this,list);
        listView.setAdapter(adapter);
    }

    private void readData(){
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor =database.rawQuery("SELECT * FROM SinhVien", null);
        list.clear();
        for(int i=0; i< cursor.getCount();i++){
            cursor.moveToPosition(i);
            int id= cursor.getInt(0);
            String ten = cursor.getString(1);
            String sdt = cursor.getString(2);
            String email = cursor.getString(3);
            String khoahoc = cursor.getString(4);
            byte[] anh= cursor.getBlob(5);
            list.add(new SinhVien(id,ten,sdt,email,khoahoc,anh));
        }
        adapter.notifyDataSetChanged();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:
                Intent intent = new Intent(this, Add.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}