package com.socket.clientserver;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Server(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            Socket socket = server.accept();
            System.out.println("Client accepted");

            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);

                }
                catch(IOException ignored) {}
            }
            System.out.println("Closing connection");

            socket.close();
            in.close();
        }
        catch(IOException ignored) {}
    }

    public static void main(String[] args) {
        new Server(5000);
    }
}
