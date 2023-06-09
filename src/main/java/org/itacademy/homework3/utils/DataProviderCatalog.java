package org.itacademy.homework3.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.models.CatalogList;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderCatalog {

    private static final Logger LOGGER = LogManager.getLogger(DataProviderCatalog.class);

    @DataProvider(name = "items")
    public Object[][] catalogItems()
    {
        CatalogList catalogList = GetFromJSON.get("data/catalogitems.json", CatalogList.class);
        List<CatalogItem> list = catalogList.getItems();
        int size = list.size();
        Object[][] data = new Object[size][1];
        for (int i=0; i< size; i++){ // перевод списка жсона в двухмерный массив датапровайдера
            data[i][0] = list.get(i);
            LOGGER.info("DATA " + data[i][0]);
        }
        return data;
    }
}
