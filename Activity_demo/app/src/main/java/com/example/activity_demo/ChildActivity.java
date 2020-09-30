package com.example.activity_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChildActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        ImageButton btnBack= (ImageButton) findViewById(R.id.btlogout);
        btnBack.setOnClickListener(new View.OnClickListener() {
                   public void onClick(View v) {
                       finish();
                   }
               });

    }
}