package com.mohammedaltwaity.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            System.out.println("Connected to server.");

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
