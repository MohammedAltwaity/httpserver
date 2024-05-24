package com.mohammedaltwaity.httpserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Json {

    private static ObjectMapper objectMapper = defaultObjectMapper();

    private static ObjectMapper defaultObjectMapper(){
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

    public static JsonNode parse(String jsonSource) throws JsonProcessingException {
        return objectMapper.readTree(jsonSource);
    }


    public static <A> A fromJson(JsonNode jsonNode, Class<A> aClass) throws JsonProcessingException {
        return objectMapper.treeToValue(jsonNode, aClass);
    }

    public  static JsonNode toJson(Object object){
        return objectMapper.valueToTree(object);
    }


    public static String stringify(JsonNode jsonNode) throws JsonProcessingException {

        return generateJson(jsonNode);
    }


    private static String generateJson(Object o) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        return objectWriter.writeValueAsString(o);
    }
}
