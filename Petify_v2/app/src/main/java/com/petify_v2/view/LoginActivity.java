package com.petify_v2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.petify_v2.R;
import com.petify_v2.controller.UserController;
import com.petify_v2.model.Album;
import com.petify_v2.model.IVolleyCallBackMessage;

import java.util.List;

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
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();



            if (!username.isEmpty() && !password.isEmpty() ) {
                UserController.logInUser(username,password, LoginActivity.this, new IVolleyCallBackMessage(){
                    @Override
                    public void onSuccess(String message, Object obj) {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                        Intent k = new Intent (LoginActivity.this, MainActivity.class); 
                        startActivity(k);
                    }

                    @Override
                    public void onSuccessInfo(List<Album> albums) {

                    }

                    @Override
                    public void onWarning(String message) {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                });
            }

        });
    }
}