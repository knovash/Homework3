package org.itacademy.homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Component Objects
 * https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/
 */

@Log4j2
public class CatalogElement {

    /** Using Selenium findElement */

//    protected WebElement root;
//    public CatalogElement(WebElement root) { this.root = root;}
//
//    public WebElement getProductTitle() {
//        return root.findElement(By.xpath(".//*[@class='product__title']"));
//    }
//    public WebElement getProductPrice() {
//        return root.findElement(By.xpath(".//*[@class='product__price-value product__price-value_primary']"));
//    }
//    public WebElement getProductOffers() {
//        return root.findElement(By.xpath(".//*[@class='button button_orange product__button']"));
//    }

    /** Using @FindBy */

    private final SearchContext driver;
    public CatalogElement(SearchContext driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
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
