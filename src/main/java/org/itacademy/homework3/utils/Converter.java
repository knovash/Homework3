package org.itacademy.homework3.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.MenuList;

import java.io.File;
import java.io.IOException;

public class Converter {

    private static final Logger LOGGER = LogManager.getLogger(Converter.class);

    public MenuList fileToObject(File file) {
        LOGGER.info("\njson file to object\n");
        ObjectMapper mapper = new ObjectMapper();
        MenuList object = null;
        try {
            object = mapper.readValue(file, MenuList.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
