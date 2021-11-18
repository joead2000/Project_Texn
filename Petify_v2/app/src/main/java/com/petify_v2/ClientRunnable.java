package com.petify_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientRunnable implements Runnable {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientRunnable(Socket s) throws IOException {
        this.socket = s;
        this.input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        this.output = new PrintWriter(socket.getOutputStream(),true);
    }
    @Override
    public void run() {

        try {
            while(true) {
                String response = input.readLine();
                //handle
            }
        } catch (IOException e) {
           System.out.println(e.getMessage());
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
