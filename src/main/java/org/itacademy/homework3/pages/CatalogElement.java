package org.itacademy.homework3.pages;

import org.itacademy.homework3.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogElement {
    private WebDriver driver;
    protected WebElement root;

    public CatalogElement(WebElement root, WebDriver driver){
        PageFactory.initElements(DriverManager.getDriver(), this);
        this.driver = driver;
        this.root=root;
    }

    @FindBy(xpath = "//*[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@class='product__price-value product__price-value_primary']")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@class='button button_orange product__button']")
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
