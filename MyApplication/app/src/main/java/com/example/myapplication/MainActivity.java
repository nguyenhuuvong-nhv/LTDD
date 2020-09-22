package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1, bt2;
    EditText tx1,tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        bt1 = (Button) findViewById(R.id.btsignup);
        bt1.setOnClickListener(this);

        bt2 = (Button) findViewById(R.id.btgo);
        bt2.setOnClickListener(this);

        tx1 = (EditText) findViewById(R.id.editTextTextPersonName3);
        tx2 = (EditText) findViewById(R.id.editTextTextPassword2);
    }

    @Override
    public void onClick(View v) {
        String user = "admin";
        String pass= "123";
        if(v == bt1) {
            setContentView(R.layout.activity_main);        }

        if(v == bt2){
            if(tx1.getText().toString().equals(user) && tx2.getText().toString().equals(pass)){
                Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                setContentView(R.layout.profielayout);}
            else
                Toast.makeText(getApplicationContext(),"Sai tên đăng nhập, mật khẩu",Toast.LENGTH_LONG).show();
        }
    }
}