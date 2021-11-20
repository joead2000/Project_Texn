package com.petify_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class Login extends AppCompatActivity {

    EditText usernameEditText,passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.btnConnect);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        btnLogin.setOnClickListener(v -> {
//            Thread thread = new Thread(() -> {
//                try  {
//                    Client client = new Client();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//
//            thread.start();
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty()) {

                try {
                    User user = new UserDBOperation().execute(username, password).get();
                    
                    if (user.getUsername() == null || user.getEmail() == null || (!user.getUsername().isEmpty() && !user.getEmail().isEmpty())) {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        finish();
                        return;
                    }
                    Toast.makeText(Login.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                } catch (ExecutionException | InterruptedException e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                return;
            }
            Toast.makeText(Login.this, "Fill every single field", Toast.LENGTH_SHORT).show();
        });

    }

    class UserDBOperation extends AsyncTask<String, Void, User> {

        @Override
        protected User doInBackground(String... strings) {
            try {
                Class.forName("org.postgresql.Driver");
                Connection conn = DriverManager.getConnection("jdbc:postgresql://10.0.2.2:5432/petify", "petify", "1234");
                String SELECT_ALL_QUERY = "SELECT * FROM users WHERE username = '" + strings[0] + "' and password = '" + strings[1] + "'";

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