package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    private Server server;
    private Socket socket;
    public PrintWriter output;

    public ServerThread(Socket socket, Server server) {
        System.out.println("New Client Connected");
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String outputString = input.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error occured " +e.getStackTrace());
        }
    }
}
