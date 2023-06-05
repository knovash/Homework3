package org.itacademy.homework3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.Menu;
import org.itacademy.homework3.models.MenuItem;
import org.itacademy.homework3.utils.MenuUtilsJSON;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    /**
     * Homework
     * drivermanager singltone
     * test page https://donerking.by/
     */
    public static void main(String[] args) {


//        LOGGER.info(Faker.instance(new Locale("ru")).name().name());
//        Faker faker = new Faker(new Locale("ru"));
//        LOGGER.info(faker.name().name());

        URL resourceItems = Main.class.getClassLoader().getResource("data/items.json");
        File fileItems = new File(Objects.requireNonNull(resourceItems).getFile());
        MenuUtilsJSON menuUtilsJSON = new MenuUtilsJSON();

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("бургер"));
        menuItems.add(new MenuItem("донер"));
        menuItems.add(new MenuItem("пончик"));
        menuItems.forEach(System.out::println);
        Menu menu = new Menu();
        menu.setItems(menuItems);

// object to JSON file
        menuUtilsJSON.objectToFile(menu, fileItems);

// JSON file to object
        Menu menuNew = menuUtilsJSON.fileToObject(fileItems);
        LOGGER.info(menuNew);


    }
}