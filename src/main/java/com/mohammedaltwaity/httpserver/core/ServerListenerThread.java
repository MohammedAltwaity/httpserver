package com.mohammedaltwaity.httpserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerListenerThread extends Thread {

    private final static Logger LOGGER = Logger.getLogger(ServerListenerThread.class.getName());
    private  int port;
    private String webroot;
    private ServerSocket serverSocket;
    public ServerListenerThread(int port, String webroot){
        this.port = port;
        this.webroot = webroot;
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void run(){


        try {
            Socket socket = serverSocket.accept();
            LOGGER.info("Connection accepted" + socket.getInetAddress());


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