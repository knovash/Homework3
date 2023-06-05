package org.itacademy.homework3.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.itacademy.homework3.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class GetFromJSON {

    public static <T> T get(String fileName, Class<T> clazz) {
        URL resourceItems = Main.class.getClassLoader().getResource(fileName);
        File fileItems = new File(Objects.requireNonNull(resourceItems).getFile());
        ObjectMapper mapper = new ObjectMapper();
        T object = null;
        try {
            object = mapper.readValue(fileItems, clazz);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return (T) object;
    }
}
