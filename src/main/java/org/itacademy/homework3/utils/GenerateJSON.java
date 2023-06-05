package org.itacademy.homework3.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public class GenerateJSON {

    public static void objectToFile(Object object, String fileName) {
        /** convert hospital object to JSON */
        System.out.println("\nJackson object to JSON\n");
        File file = new File(fileName);
        String jsonOut = null;
        try {
            jsonOut = new ObjectMapper().writeValueAsString(object);
            System.out.println(jsonOut);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writerPP = mapper.writer(new DefaultPrettyPrinter());
            writerPP.writeValue(file, object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JSON saved to file \n");
    }

}
