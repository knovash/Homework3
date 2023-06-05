package org.itacademy.homework3.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.MenuItem;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderJSON {

    private static final Logger LOGGER = LogManager.getLogger(DataProviderJSON.class);

    @DataProvider(name = "menuItems")
    public Object[][] menuItems() // имя метода дата провайдера
    {
        List<MenuItem> menuList= GetMenuList.get(); // всять список данных типа MenuItem из жсон
        int size = menuList.size();
        Object[][] data = new Object[size][1];
        for (int i=0; i< size; i++){ // перевод списка жсона в двухмерный массив датапровайдера
            data[i][0] = menuList.get(i);
            LOGGER.info("ARR " + data[i][0]);
        }
        return data;
    }
}
