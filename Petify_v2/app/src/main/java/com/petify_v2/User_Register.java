package com.petify_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class User_Register extends AppCompatActivity {
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

                try {
                    User user = new UserDBOperation().execute(username,email,password).get();

                    if (user.getUsername() == null || user.getEmail() == null || (!user.getUsername().isEmpty() && !user.getEmail().isEmpty())) {

                        finish();
                        return;
                    }

                } catch (ExecutionException | InterruptedException e) {
                    Toast.makeText(getApplicationContext(), "Please Login Now",Toast.LENGTH_LONG).show() ;
                    //Toast.makeText(getApplicationContext(), "Something went wrong" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                return;
            }

            Toast.makeText(User_Register.this, "Fill every single field", Toast.LENGTH_SHORT).show();

        });


    }


    class UserDBOperation extends AsyncTask<String, Void, User> {

        @Override
        protected User doInBackground(String... strings) {
            try {
                Class.forName("org.postgresql.Driver");
                Connection conn = DriverManager.getConnection("jdbc:postgresql://10.0.2.2:5432/petify", "petify", "1234");
                String SELECT_ALL_QUERY = "insert into users(username,email,password) values ('"+ strings[0] +"','"+ strings[1] +"','"+ strings[2] +"')";

                Statement statement = conn.createStatement();

                ResultSet result = statement.executeQuery(SELECT_ALL_QUERY);

                String username = "",email = "";

                while (result.next()) {
                    username = result.getString("username");
                    email = result.getString("email");
                }

                conn.close() ;

                return new User(username,email);

            } catch (ClassNotFoundException classNotFoundException) {
                Toast.makeText(getApplicationContext(), "Unable to connect", Toast.LENGTH_SHORT).show();
            } catch (SQLException exception) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
            return null;
        }
    }

}