package org.itacademy.homework3;

import org.itacademy.homework3.models.*;
import org.itacademy.homework3.utils.GenerateJSON;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<MenuItem> menuList = new ArrayList<>();
        menuList.add(new MenuItem("бургер"));
        menuList.add(new MenuItem("донер"));
        menuList.add(new MenuItem("пончик"));
        MenuList menuItems = new MenuList();
        menuItems.setItems(menuList);
        GenerateJSON.objectToFile(menuItems, "menuitems.json");


        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Кульман", "15"));
        addressList.add(new Address("Богдановича", "10"));
        AddressList addresses = new AddressList();
        addresses.setAddresses(addressList);
        GenerateJSON.objectToFile(addresses, "addresses.json");

//        List<CatalogItem> catalogList = new ArrayList<>();
//        catalogList.add(new CatalogItem("телевизор"));
////        catalogList.add(new CatalogItem("телефон"));
////        catalogList.add(new CatalogItem("ноутбук"));
//        CatalogList catalogItems = new CatalogList();
//        catalogItems.setItems(catalogList);
//        GenerateJSON.objectToFile(catalogItems, "catalogitems.json");


    }
}


