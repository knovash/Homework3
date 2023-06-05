package org.itacademy.homework3.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.Address;
import org.itacademy.homework3.models.AddressList;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderDelivery {

    private static final Logger LOGGER = LogManager.getLogger(DataProviderDelivery.class);

    @DataProvider(name = "addresses")
    public Object[][] adresses()
    {
        AddressList addressList = GetFromJSON.get("data/addresses.json", AddressList.class);
        List<Address> addresses = addressList.getAddresses();
        int size = addresses.size();
        Object[][] data = new Object[size][1];
        for (int i = 0; i < size; i++) { // перевод списка жсона в двухмерный массив датапровайдера
            data[i][0] = addresses.get(i);
            LOGGER.info("DATA " + data[i][0]);
        }
        return data;
    }
}
