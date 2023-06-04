package org.itacademy.homework3.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.itacademy.homework3.models.MenuLombok;

import java.io.File;
import java.io.IOException;

public class MenuUtilsJSONL {

    public MenuLombok fileToObject(File file) {
        System.out.println("\njson file to object\n");
        ObjectMapper mapper = new ObjectMapper();
        MenuLombok object = null;
        try {
            object = mapper.readValue(file, MenuLombok.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
