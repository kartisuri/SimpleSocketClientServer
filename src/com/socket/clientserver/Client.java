package com.socket.clientserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    private void sendData() {
        try {
            String serverName = "127.0.0.1";
            int port = 5000;
            Socket socket=new Socket(serverName, port);
            System.out.println(socket.getInetAddress());
            OutputStream output=socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(output);
            boolean isDataStreamOpen = true;
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            while(isDataStreamOpen) {
                System.out.println("Enter the text");
                String enteredText = br.readLine();
                if(enteredText.equals("quit")) {
                    isDataStreamOpen = false;
                }
                out.writeUTF(enteredText);
            }
            out.close();
            socket.close();
        }
        catch(Exception ignored) {}
    }

    public static void main(String[] args) {
        Client sender = new Client();
        sender.sendData();
    }
}
