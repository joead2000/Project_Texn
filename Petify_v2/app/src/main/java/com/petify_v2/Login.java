package com.petify_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Login extends AppCompatActivity {

    EditText usernameEditText,passwordEditText;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(() -> {
            new Client();
        }).start();

        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.btnConnect);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, User_Register.class));

            }
        });



        btnLogin.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username != null && password != null &&
                    !username.isEmpty() && !password.isEmpty()) {
                JSONArray registrationPacket = new JSONArray();
                registrationPacket.put("0");
                registrationPacket.put(username);
                registrationPacket.put(password);
                System.out.println(registrationPacket.toString());
                Client.getInstance.SendMessage(registrationPacket.toString());
            }
        });

    }
}