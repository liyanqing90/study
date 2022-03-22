package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_acticity);
        TextView textName = findViewById(R.id.name);
        TextView textPwd = findViewById(R.id.pwd);
        TextView textAge = findViewById(R.id.age);
        Button btnBack = findViewById(R.id.backlogin);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String pwd = intent.getStringExtra("pwd");
        int age = intent.getIntExtra("age",19);
        textName.setText(name);
        textPwd.setText(pwd);
        textAge.setText(String.valueOf(age));

        btnBack.setOnClickListener(view -> {
            Intent intent1 = new Intent(Main.this, LoginActivity.class);
            startActivity(intent1);
        });
    }
}