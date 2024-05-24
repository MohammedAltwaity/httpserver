package com.mohammedaltwaity.httpserver.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.mohammedaltwaity.httpserver.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {

    private static ConfigurationManager configurationManager;
    private  static  Configuration currentConfiguration;

    private ConfigurationManager(){

    }
    public static ConfigurationManager getInstance(){
        if(configurationManager == null){
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }





    //to load configuration file by the path
   public  void loadConfigurationFile(String filePath) throws IOException {
       FileReader fileReader = new FileReader(filePath);
       StringBuffer sb = new StringBuffer();
       int i;

       while((i = fileReader.read()) != -1){
                sb.append((char) i);
       }
       JsonNode conf = Json.parse(sb.toString());
       currentConfiguration = Json.fromJson(conf, Configuration.class);

   }




   //returns the current loaded configuration
   public  Configuration getCurrentConfiguration(){
            if(currentConfiguration == null){
                throw new  HttpConfigurationException("no current conf");
            }
            return currentConfiguration;
   }
}
