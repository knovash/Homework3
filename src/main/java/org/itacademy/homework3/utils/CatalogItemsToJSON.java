package org.itacademy.homework3.utils;

import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.models.CatalogItemList;
import org.itacademy.homework3.models.Rule;
import org.itacademy.homework3.models.RulesList;

import java.util.List;

public class CatalogItemsToJSON {

    public static void toJson(List<CatalogItem> list, String fileName) {
        CatalogItemList catalogItemList = new CatalogItemList();
        catalogItemList.setItems(list);
        GenerateJSON.objectToFile(catalogItemList, fileName);
    }
}