package org.itacademy.homework3.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.MenuLombok;

import java.io.File;
import java.io.IOException;

public class MenuUtilsJSONL {

    private static final Logger LOGGER = LogManager.getLogger(MenuUtilsJSONL.class);

    public MenuLombok fileToObject(File file) {
        LOGGER.info("\njson file to object\n");
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
