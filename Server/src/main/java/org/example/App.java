package org.example;

import java.io.IOException;

class  App
{
    public static void main(String args[]) throws IOException
    {
        new Config();
        DataBaseConnection conn = new DataBaseConnection();
        conn.getConnection();
        Server server = new Server(Config.getInstance.getInt("server_port"));
    }
}