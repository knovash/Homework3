package org.itacademy.homework3.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.itacademy.homework3.models.Address;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class UtilsJSON {

    public Address fileToObject(File file) {
        System.out.println("\njson file to object\n");
        ObjectMapper mapper = new ObjectMapper();
        Address object = null;
        try {
            object = mapper.readValue(file, Address.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    public void objectToFile(Address address, File file) {
        System.out.println("\nobject to json file\n");
        String jsonOut = null;
        try {
            jsonOut = new ObjectMapper().writeValueAsString(address);
            System.out.println("JSON: " + jsonOut);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writerPP = mapper.writer(new DefaultPrettyPrinter());
            writerPP.writeValue(file, address);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JSON saved to file \n");
    }
}
