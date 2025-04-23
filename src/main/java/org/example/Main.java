package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;


public class Main {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        LocalDateTime localDateTime = LocalDateTime.now();
        String result = parseDate(localDateTime);
        System.out.println(result);
    }

    public static String parseDate(LocalDateTime localDateTime) throws JsonProcessingException {
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(localDateTime)
                .replace(",",":")
                .replace("[","")
                .replace("]","");
    }

}