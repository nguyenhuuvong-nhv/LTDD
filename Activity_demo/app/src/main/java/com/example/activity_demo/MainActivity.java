package com.example.activity_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button btlogin;
    EditText txUser,txtPass;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btlogin =(Button) findViewById(R.id.btlogin);
        txUser = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        txtPass= (EditText) findViewById(R.id.editTextTextPassword3);

        btlogin.setOnClickListener(new View.OnClickListener() {
               public void onClick(View arg0) {
                   if(txUser.getText().toString().equals("admin") && txtPass.getText().toString().equals("123")){
                       Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                       doOpenChildActivity();}
                   else
                       Toast.makeText(getApplicationContext(),"Sai tên đăng nhập, mật khẩu",Toast.LENGTH_LONG).show();
               }
           });
    }
    public void doOpenChildActivity()
    {
        Intent myIntent=new Intent(this, ChildActivity.class);
        startActivity(myIntent);
    }
}