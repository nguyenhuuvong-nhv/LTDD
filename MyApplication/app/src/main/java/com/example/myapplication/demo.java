package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class demo extends AppCompatActivity  implements View.OnClickListener {
    Button btlogin;
    EditText tx1, tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btlogin = (Button) findViewById(R.id.btlogin);
        btlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btlogin)
            setContentView(R.layout.accc);
    }
}