package com.petify_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnConnect = findViewById(R.id.btnConnect);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client client = new Client();
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                            Client client = new Client();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();
               new Task().execute();
               startActivity(new Intent(Login.this,MainActivity.class));
            }
        });

    }


    class Task extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("org.postgresql.Driver");
                Connection conn = DriverManager.getConnection("jdbc:postgresql://10.0.2.2:5432/postgres", "postgres", "geogram");
                System.out.println("Connection Established");
                conn.close() ;
            } catch (SQLException | ClassNotFoundException throwable) {
                System.out.println("Unable to Connect");
                System.out.println(throwable.getMessage());
            }
            return null;
        }
    }
}