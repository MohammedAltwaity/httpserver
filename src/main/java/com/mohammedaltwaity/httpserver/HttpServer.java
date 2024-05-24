package com.mohammedaltwaity.httpserver;


import com.mohammedaltwaity.httpserver.config.Configuration;
import com.mohammedaltwaity.httpserver.core.ServerListenerThread;

// the main class
public class HttpServer {




    public static void main(String[] args) {
        System.out.println("We started the server");

        System.out.println("Port: " + Configuration.port);
        System.out.println("Webroot: " + Configuration.webroot);

        ServerListenerThread serverListenerThread = new ServerListenerThread(Configuration.port, Configuration.webroot);
        serverListenerThread.start();

    }
}
