package org.example;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Server {
    private ArrayList<ServerThread> threads = new ArrayList<>();

    public Server(int port) throws IOException {
        try (ServerSocket serversocket = new ServerSocket(5000)){
            while(true) {
                Socket socket = serversocket.accept();
                ServerThread serverThread = new ServerThread(socket, this);

                threads.add(serverThread);
                serverThread.start();
            }
        } catch (Exception e) {
            System.out.println("Error occured in main: " + e.getStackTrace());
        }
    }

    public void printToALlClients(String outputString) {
        for( ServerThread sT: threads) {
            sT.output.println(outputString);
        }

    }
}