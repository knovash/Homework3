package org.itacademy.homework3.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.itacademy.homework3.models.ItemLombok;
import org.itacademy.homework3.models.Menu;
import org.itacademy.homework3.models.MenuLombok;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    @DataProvider(name = "menuItems")
    public Object[][] menuItems() // имя метода дата провайдера
    {
        MenuLombok menu = GetDataLombok.get(); // моя гетдата читала файл data/items.json" и запускала конвертер json to object
        // menu содержит лисит менюитемов. надо брать гет итемс
        int menuSize = menu.getItems().size();

        // Рома тут берет файл
//        String filePath = "src/test/resources/test-data/userData.json";
        // Рома запускает конвертер json и получает лист менюитемов
//        List<UserData> userDataList = readTestDataFromJson(filePath);


        Object[][] arr = new Object[menuSize][1];
        for (int i=0; i< menuSize; i++){
            arr[i][0] = menu.getItems().get(i);
            System.out.println("ARR " + arr[i][0]);
        }
        return arr;
    }

    // у меня это реализовано в GetData я получаю menu а из него getItems в list
//    private List<ItemLombok> readTestDataFromJson(String filePath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = new File(filePath);
//
//        try (FileInputStream fis = new FileInputStream(file)) {
//            return objectMapper.readValue(fis, new TypeReference<List<ItemLombok>>() {
//            });
//        }
//    }
}
