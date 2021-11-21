package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {


        private Connection connection;

        public Connection getConnection() {
            try {
                connection = DriverManager.getConnection(Config.getInstance.get("database_url"),
                        Config.getInstance.get("database_user"),
                        Config.getInstance.get("database_password"));
                System.out.println("Connection Established");
            } catch (SQLException throwable) {
                System.out.println("Unable to connect!");
            }
            return connection;
        }



}
