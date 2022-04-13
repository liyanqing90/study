package com.example.study;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView editName, editPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        editName = findViewById(R.id.username);
        editPwd = findViewById(R.id.password);
        Button btnLogin = findViewById(R.id.btnRegister);
        Button btnReset = findViewById(R.id.bitRest);
        Button btnReg = findViewById(R.id.register);
        Button btnUser = findViewById(R.id.set_btn);
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Intent data = result.getData();
            String name = null;
            if (data != null) {
                name = data.getStringExtra("name");
            }
            String pwd = null;
            if (data != null) {
                pwd = data.getStringExtra("pwd");
            }
            editName.setText(name);
            editPwd.setText(pwd);
        });
        btnLogin.setOnClickListener(view -> {
            String name = editName.getText().toString();
            String pwd = editPwd.getText().toString();
            if (TextUtils.isEmpty(name)) {
                editName.setError("用户名不能为空");
            } else if (TextUtils.isEmpty(pwd)) {
                editPwd.setError("密码不能为空");
            } else {
                Intent intent = new Intent(LoginActivity.this, Main.class);
                intent.putExtra("name", name);
                intent.putExtra("pwd", pwd);
                intent.putExtra("age", 10);
                startActivity(intent);
            }
        });

        btnReset.setOnClickListener(view -> {
            editName.setText("");
            editPwd.setText("");
        });
        btnReg.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            launcher.launch(intent);
        });
        btnUser.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, UserProfile.class);
            launcher.launch(intent);
        });

    }
}
