package org.itacademy.homework3.utils;

import org.itacademy.homework3.Main;
import org.itacademy.homework3.models.MenuLombok;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class GetDataLombok {

    public static MenuLombok get() {
        URL resourceItems = Main.class.getClassLoader().getResource("data/items.json");
        File fileItems = new File(Objects.requireNonNull(resourceItems).getFile());
        MenuUtilsJSONL menuUtilsJSONL = new MenuUtilsJSONL();
        MenuLombok menuNew = menuUtilsJSONL.fileToObject(fileItems);
        return menuNew;
    }
}
