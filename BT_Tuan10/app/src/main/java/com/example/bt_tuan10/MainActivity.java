package com.example.bt_tuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.bt_tuan10.model.Profile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Profile> arrayProfile;
    adapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1= (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });


        Anhxa();
        adapter= new adapter2(MainActivity.this,R.layout.row2, arrayProfile);
        gridView.setAdapter(adapter);
    }

    private void Anhxa() {
        gridView= (GridView) findViewById(R.id.gridview);
        arrayProfile = new ArrayList<>();
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner1));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner2));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner3));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner4));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner5));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner1));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner2));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner3));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner4));
        arrayProfile.add(new Profile("Nguyễn Hữu Vọng","Đà Nẵng, Việt Nam","0389251012",R.drawable.banner5));


    }
}