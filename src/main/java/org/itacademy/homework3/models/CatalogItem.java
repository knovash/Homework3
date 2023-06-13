package org.itacademy.homework3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItem {

    String title;
    String price;
    String offers;

    @Override
    public String toString() {
        return "\nCatalogItem{" +
                "\nname='" + title + '\'' +
                "\nprice='" + price + '\'' +
                "\noffers='" + offers + '\'' +
                '}';
    }
}
