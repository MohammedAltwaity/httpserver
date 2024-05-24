package com.mohammedaltwaity.httpserver;


import com.mohammedaltwaity.httpserver.config.Configuration;
import com.mohammedaltwaity.httpserver.config.ConfigurationManager;

import java.io.IOException;

// the main class
public class HttpServer {

    public static void main(String[] args) throws IOException {
        System.out.println("we started the server");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
       Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println(conf.getPort());
        System.out.println(conf.getWebroot());
    }
}
