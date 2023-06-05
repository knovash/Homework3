package org.itacademy.homework3.utils;

import org.itacademy.homework3.Main;
import org.itacademy.homework3.models.MenuItem;
import org.itacademy.homework3.models.MenuList;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class GetMenuList {

    public static List<MenuItem> get() {
        URL resourceItems = Main.class.getClassLoader().getResource("data/items.json");
        File fileItems = new File(Objects.requireNonNull(resourceItems).getFile());
        Converter converter = new Converter();
        MenuList menu = converter.fileToObject(fileItems);
        return menu.getItems();
    }
}
