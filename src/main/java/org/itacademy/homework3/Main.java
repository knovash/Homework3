package org.itacademy.homework3;

import org.itacademy.homework3.models.Address;
import org.itacademy.homework3.models.AddressList;
import org.itacademy.homework3.models.MenuItem;
import org.itacademy.homework3.models.MenuList;
import org.itacademy.homework3.utils.GenerateJSON;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<MenuItem> menuList = new ArrayList<>();
        menuList.add(new MenuItem("бургер"));
        menuList.add(new MenuItem("донер"));
        menuList.add(new MenuItem("пончик"));
        MenuList items = new MenuList();
        items.setItems(menuList);
        GenerateJSON.objectToFile(items, "menuitems.json");


        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Кульман", "15"));
        addressList.add(new Address("Богдановича", "10"));
        AddressList addresses = new AddressList();
        addresses.setAddresses(addressList);
        GenerateJSON.objectToFile(addresses, "addresses.json");


    }
}


