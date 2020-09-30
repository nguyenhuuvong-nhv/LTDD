package com.example.listview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProfile;
    ArrayList<Profile> arrayProfile;
    ProfileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter= new ProfileAdapter(MainActivity.this,R.layout.lv_item, arrayProfile);
        lvProfile.setAdapter(adapter);
    }

    private void Anhxa() {
        lvProfile= (ListView) findViewById(R.id.lvProfile);
        arrayProfile = new ArrayList<>();
        arrayProfile.add(new Profile("Java","Java là một ngôn ngữ lập lập trình, được phát triển bởi Sun Microsystem vào năm 1995, " +
                "là ngôn ngữ kế thừa trực tiếp từ C/C++ và là một ngôn ngữ lập trình hướng đối tượng.",R.drawable.h_java));
        arrayProfile.add(new Profile("Python","Python là một ngôn ngữ lập trình thông dịch (interpreted), hướng đối tượng (object-oriented), " +
                "và là một ngôn ngữ bậc cao (high-level)  ngữ nghĩa động (dynamic semantics)",R.drawable.python));
        arrayProfile.add(new Profile("NodeJS","NodeJS là một môi trường chạy JavaScript ( JavaScript Runtime Environment) bên ngoài trình duyệt. " +
                "NodeJS cũng bao gồm các thành phần thư viện khác để nó có thể hoạt động như một Web Application Server.",R.drawable.nodejs));
        arrayProfile.add(new Profile("ReactJS","React (Hay ReactJS, React.js) là một thư viện Javascript mã " +
                "nguồn mở để xây dựng các thành phần giao diện có thể tái sử dụng.",R.drawable.react));
        arrayProfile.add(new Profile("Oracle APEX","Oracle Application Express (Oracle APEX), trước đây gọi là HTML DB, " +
                "là một công cụ phát triển ứng dụng web nhanh chóng cho các cơ sở dữ liệu Oracle.",R.drawable.orc));

    }
}