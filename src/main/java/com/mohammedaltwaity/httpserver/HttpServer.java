package com.mohammedaltwaity.httpserver;


import com.mohammedaltwaity.httpserver.config.Configuration;
import com.mohammedaltwaity.httpserver.config.ConfigurationManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// the main class
public class HttpServer {

    public static void main(String[] args) {
        System.out.println("we started the server");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
       Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println(conf.getPort());
        System.out.println(conf.getWebroot());


        try {
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
          Socket socket = serverSocket.accept();

         InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();


            String html = "<html><head>My server</head><body><h1>From my server</h1></body></html>";
            String CRLF = "\r\n";

// Content length of the HTML content
            int contentLength = html.getBytes().length;

// Construct the HTTP response
            String response = "HTTP/1.1 200 OK" + CRLF; // Status line
            response += "Content-Length: " + contentLength + CRLF; // Content length header
            response += "Content-Type: text/html" + CRLF; // Content type header
            response += CRLF; // Empty line separating headers and body
            response += html; // HTML body

            outputStream.write(response.getBytes());



            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
