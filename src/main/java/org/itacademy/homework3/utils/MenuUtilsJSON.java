package org.itacademy.homework3.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.Menu;

import java.io.File;
import java.io.IOException;

public class MenuUtilsJSON {

    private static final Logger LOGGER = LogManager.getLogger(MenuUtilsJSON.class);

    public Menu fileToObject(File file) {
        LOGGER.info("\njson file to object\n");
        ObjectMapper mapper = new ObjectMapper();
        Menu object = null;
        try {
            object = mapper.readValue(file, Menu.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    public void objectToFile(Menu object, File file) {
        LOGGER.info("\nobject to json file\n");
        String jsonOut = null;
        try {
            jsonOut = new ObjectMapper().writeValueAsString(object);
            LOGGER.info("JSON: " + jsonOut);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writerPP = mapper.writer(new DefaultPrettyPrinter());
            writerPP.writeValue(file, object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("JSON saved to file \n");
    }
}
