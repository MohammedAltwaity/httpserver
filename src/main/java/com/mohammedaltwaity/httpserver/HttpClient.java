package com.mohammedaltwaity.httpserver;

import java.io.*;
import java.net.Socket;

public class HttpClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            System.out.print("Connected to server.");

//                OutputStream outputStream = socket.getOutputStream();
//                outputStream.write("Ali".getBytes());
            // Reading response from the server
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    System.out.println(responseLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
