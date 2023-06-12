package org.itacademy.homework3.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.models.CatalogItemList;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderCatalog {

    private static final Logger LOGGER = LogManager.getLogger(DataProviderCatalog.class);

    @DataProvider(name = "catalogitems")
    public Object[][] catalogItems()
    {
        CatalogItemList catalogItemList = GetFromJSON.get("data/catalogitems.json", CatalogItemList.class);
        List<CatalogItem> list = catalogItemList.getItems();
        int size = list.size();
        Object[][] data = new Object[size][1];
        for (int i=0; i< size; i++){ // перевод списка жсона в двухмерный массив датапровайдера
            data[i][0] = list.get(i);
            LOGGER.info("DATA " + data[i][0]);
        }
        return data;
    }
}
