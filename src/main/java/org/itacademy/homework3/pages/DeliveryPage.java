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

    @FindBy(xpath = "//div[@id='delivery_status' and @class='success']")
    private WebElement statusSuccess;

    @FindBy(xpath = "//div[@id='delivery_status' and @class='fail']")
    private WebElement statusFail;

    public void enterFieldStreet(String street) {
        fieldStreet.sendKeys(street);;
    }
    public void enterFieldBuilding(String building) {
        fieldBuilding.sendKeys(building);;
    }

    public void clickButtonCheck() {
        WaitUtils.waitForVisibility(buttonCheck);
        buttonCheck.click();
    }

    public Boolean getStatus() {
//        LOGGER.info("CLASS NAME " + deliveryPage.getStatus().getAttribute("class"));
        Boolean status = false;
        try {
            status = statusSuccess.isDisplayed();
            LOGGER.info("SUCC " + statusSuccess.getText());
        } catch (NoSuchElementException e) {
            LOGGER.info("NO ELEMENT");
        }
        LOGGER.info("STATUS " + status);
        return status;
    }

}