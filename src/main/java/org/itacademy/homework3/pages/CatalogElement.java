package org.itacademy.homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class CatalogElement {
    private WebDriver driver;
    protected WebElement root;
//
    public CatalogElement(WebElement root){
        PageFactory.initElements(driver, this);
        this.root=root;

    }

    @FindBy(xpath = ".//*[@class='product__title']")
    private WebElement productTitle;

    @FindBy(xpath = ".//*[@class='product__price-value product__price-value_primary']")
    private WebElement productPrice;

    @FindBy(xpath = ".//*[@class='button button_orange product__button']")
    private WebElement productOffers;

    public WebElement getProductTitle() {
//        log.info("ROOT " + root.getAttribute("outerHTML"));
//        log.info("ROOT.xpath " + root.findElement(By.xpath(".//*[@class='product__title']")).getText());
        log.info("ROOT.title " + productTitle.getAttribute("outerHTML"));
        return productTitle;
    }
    public WebElement getProductPrice() {
        return productPrice;
    }
    public WebElement getProductOffers() {
        return productOffers;
    }

//    public WebElement getProductTitle() {
//        log.info("ROOT " + root.getAttribute("outerHTML"));
//        log.info("ROOT.xpath " + root.findElement(By.xpath(".//*[@class='product__title']")).getText());
//        return root.findElement(By.xpath(".//*[@class='product__title']"));
//    }
//    public WebElement getProductPrice() {
//        return root.findElement(By.xpath(".//*[@class='product__price-value product__price-value_primary']"));
//    }
//    public WebElement getProductOffers() {
//        return root.findElement(By.xpath(".//*[@class='button button_orange product__button']"));
//    }

}
