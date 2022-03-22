package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private TextView editName, editPwd, editComPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        editName = findViewById(R.id.username);
        editPwd = findViewById(R.id.password);
        editComPwd = findViewById(R.id.comPwd);
        Button reg = findViewById(R.id.btnRegister);
        reg.setOnClickListener(view -> {
            String name = editName.getText().toString();
            String pwd = editPwd.getText().toString();
            String comPwd = editComPwd.getText().toString();
            if (TextUtils.isEmpty(name)) {
                editName.setError("用户名不能为空");
            } else if (TextUtils.isEmpty(pwd)) {
                editPwd.setError("密码不能为空");
            } else if (!pwd.equals(comPwd)) {
                editComPwd.setError("密码输入不一致");
            } else {
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("pwd", pwd);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}