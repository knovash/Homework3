package org.itacademy.homework3.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.MenuItem;
import org.itacademy.homework3.models.MenuList;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderSearch {

    private static final Logger LOGGER = LogManager.getLogger(DataProviderSearch.class);

    @DataProvider(name = "menuItems")
    public Object[][] menuItems()
    {
        MenuList menuList = GetFromJSON.get("data/items.json", MenuList.class);
        List<MenuItem> list = menuList.getItems();
        int size = list.size();
        Object[][] data = new Object[size][1];
        for (int i=0; i< size; i++){ // перевод списка жсона в двухмерный массив датапровайдера
            data[i][0] = list.get(i);
            LOGGER.info("DATA " + data[i][0]);
        }
        return data;
    }
}
