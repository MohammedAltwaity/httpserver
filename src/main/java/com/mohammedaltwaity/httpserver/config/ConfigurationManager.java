package com.mohammedaltwaity.httpserver.config;

import com.fasterxml.jackson.core.JsonProcessingException;
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
   public  void loadConfigurationFile(String filePath) {
       FileReader fileReader = null;
       try {
           fileReader = new FileReader(filePath);
       } catch (FileNotFoundException e) {
           throw new HttpConfigurationException(e.getMessage());
       }
       StringBuffer sb = new StringBuffer();
       int i;

       while(true){
           try {
               if (!((i = fileReader.read()) != -1)) break;
           } catch (IOException e) {
               throw new HttpConfigurationException(e.getMessage());
           }
           sb.append((char) i);
       }
       JsonNode conf = null;
       try {
           conf = Json.parse(sb.toString());
       } catch (JsonProcessingException e) {
           throw new RuntimeException(e);
       }
       try {
           currentConfiguration = Json.fromJson(conf, Configuration.class);
       } catch (JsonProcessingException e) {
           throw new RuntimeException(e);
       }

   }




   //returns the current loaded configuration
   public  Configuration getCurrentConfiguration(){
            if(currentConfiguration == null){
                throw new  HttpConfigurationException("no current conf");
            }
            return currentConfiguration;
   }
}
