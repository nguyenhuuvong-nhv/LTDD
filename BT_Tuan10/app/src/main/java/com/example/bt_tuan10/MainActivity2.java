package com.example.bt_tuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.bt_tuan10.model.Profile;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    ArrayList<Profile> arrayProfile;
    ProfileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button bt2= (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });


        Anhxa();
        adapter= new ProfileAdapter(MainActivity2.this,R.layout.row, arrayProfile);
        listView.setAdapter(adapter);
    }

    private void Anhxa() {
        listView= (ListView) findViewById(R.id.lv_profile);
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