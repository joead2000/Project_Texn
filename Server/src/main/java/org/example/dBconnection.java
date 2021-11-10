package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dBconnection {
    public class ConnectionDriver {

        private Connection connection;

        public Connection getConnection() {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "spotify", "12345");
            } catch (SQLException throwable) {
                System.out.println("Unable to connect!");
            }
            return connection;
        }

    }

}
