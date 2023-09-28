package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Create a map
        Map<String, Object> map = new HashMap<>();
        map.put("age", 25);
        map.put("city", "New York");
        map.put("dodo", "bye");


        String json = JSON.stringify(map);

        Map<String, Object> newMap = JSON.parse(json);


        System.out.println(newMap);


    }
}


class JSON {
    public static String stringify(Map<String, Object> json) {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(json);


        } catch (Exception e) {
            System.err.println("Error parsing json object " + json);
            e.printStackTrace();
        }


        return null;
    }

    public static Map<String, Object> parse(String json) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, new TypeReference<>() {
            });

        } catch (Exception e) {
            System.err.println("Error parsing json string: " + json);
            e.printStackTrace();
        }

        return null;
    }
}