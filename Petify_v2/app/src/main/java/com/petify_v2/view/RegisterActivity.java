package com.petify_v2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.petify_v2.R;
import com.petify_v2.controller.UserController;
import com.petify_v2.model.Album;
import com.petify_v2.model.IVolleyCallBackMessage;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class RegisterActivity extends AppCompatActivity {
    Button btnonregisterform;
    EditText usernameregister, passwordregister , emailregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        usernameregister = findViewById(R.id.usernameregister);
        passwordregister= findViewById(R.id.passwordregister);
        emailregister = findViewById(R.id.emailregister);
        btnonregisterform = findViewById(R.id.btnOnRegisterForm);


        btnonregisterform.setOnClickListener(v ->{
            String username = usernameregister.getText().toString().trim();
            String email    = emailregister.getText().toString().trim();
            String password = passwordregister.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty() && ! email.isEmpty()) {
                UserController.registerUser(username, email, password, RegisterActivity.this, new IVolleyCallBackMessage() {
                    @Override
                    public void onSuccess(String message) {
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSuccessInfo(List<Album> albums) {

                    }

                    @Override
                    public void onWarning(String message) {
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                });
            }

        });


    }

}