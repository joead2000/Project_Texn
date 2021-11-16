package org.example;

import java.io.IOException;

class  App
{
    public static void main(String args[]) throws IOException
    {

        DataBaseConnection conn = new DataBaseConnection();
        conn.getConnection();
        Server server = new Server(65535);

    }
}