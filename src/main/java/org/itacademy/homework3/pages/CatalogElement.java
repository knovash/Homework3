package org.itacademy.homework3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogElement extends BaseElement {

    public CatalogElement(WebElement root){
        super(root);
    }


    @FindBy(xpath = ".//*[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = ".//*[@class='product__price-value product__price-value_primary']")
    private WebElement productPrice;

    @FindBy(xpath = ".//*[@class='button button_orange product__button']")
    private WebElement productOffers;

    public WebElement getProductTitle() {
        return productTitle;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getProductOffers() {
        return productOffers;
    }
}
