package com.petify_v2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.petify_v2.R;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditText,passwordEditText;
    Button btnRegister,btnskip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.btnConnect);

        btnskip = findViewById(R.id.btnskip);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));

        btnskip.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        });

        btnLogin.setOnClickListener(v -> {

        });
    }
}