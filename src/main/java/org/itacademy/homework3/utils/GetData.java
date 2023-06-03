package org.itacademy.homework3.utils;

import org.itacademy.homework3.Main;
import org.itacademy.homework3.models.Menu;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class GetData {

    public static Menu get() {
        URL resourceItems = Main.class.getClassLoader().getResource("data/items.json");
        File fileItems = new File(Objects.requireNonNull(resourceItems).getFile());
        MenuUtilsJSON menuUtilsJSON = new MenuUtilsJSON();
        Menu menuNew = menuUtilsJSON.fileToObject(fileItems);
        return menuNew;
    }
}
