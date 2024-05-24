package com.mohammedaltwaity.httpserver;


import com.mohammedaltwaity.httpserver.config.Configuration;
import com.mohammedaltwaity.httpserver.config.ConfigurationManager;
import com.mohammedaltwaity.httpserver.core.ServerListenerThread;
import java.util.logging.Logger;

// the main class
public class HttpServer {

    private final static Logger LOGGER = Logger.getLogger(HttpServer.class.getName());


    public static void main(String[] args) {
        LOGGER.info("We started the server");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
       Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        LOGGER.info("Port: " + conf.getPort());
        LOGGER.info("Webroot: " + conf.getWebroot());

        ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
        serverListenerThread.start();


    }
}
