package org.itacademy.homework3.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage extends BasePage {

    private WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(DeliveryPage.class);

    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='city']")
    private WebElement fieldCity;

    @FindBy(xpath = "//*[@id='street']")
    private WebElement fieldStreet;

    @FindBy(xpath = "//*[@id='building']")
    private WebElement fieldBuilding;

    @FindBy(xpath = "//*[@id='search-query']")
    private WebElement buttonCheck;

    @FindBy(xpath = "//div[@id='delivery_status']")
    private WebElement status;

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getFieldCity() {
        return fieldCity;
    }

    public WebElement getFieldStreet() {
        return fieldStreet;
    }

    public WebElement getFieldBuilding() {
        return fieldBuilding;
    }

    public WebElement getButtonCheck() {
        return buttonCheck;
    }

    public WebElement getStatus() {
        return status;
    }
}