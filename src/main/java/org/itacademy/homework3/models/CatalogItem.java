package org.itacademy.homework3.models;


public class CatalogItem {

    String name;
    String price;
    String offers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "CatalogItem{" +
                "\nname='" + name + '\'' +
                "\nprice='" + price + '\'' +
                "\noffers='" + offers + '\'' +
                '}';
    }
}
