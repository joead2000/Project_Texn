package com.petify_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {


        private Connection connection;

        public Connection getConnection() {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "petify", "1234");
                System.out.println("Connection Established");
            } catch (SQLException throwable) {
                System.out.println("Unable to connect!");
            }
            return connection;
        }



}
