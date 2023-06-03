package org.itacademy.homework3;

import org.itacademy.homework3.models.Address;
import org.itacademy.homework3.utils.UtilsJSON;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {

    /**
     * Homework
     * drivermanager singltone
     * test page https://donerking.by/
     */
    public static void main(String[] args) {

        File file = Paths.get("data/ss.json").toFile();

        Address address = new Address("Kulddddman", "15");
        UtilsJSON utilsJSON = new UtilsJSON();
        utilsJSON.objectToFile(address, file);

        Address addressNew = new Address();
        System.out.println("NEW " + addressNew);
        addressNew = utilsJSON.fileToObject(file);
        System.out.println("NEW " + addressNew);

    }
}