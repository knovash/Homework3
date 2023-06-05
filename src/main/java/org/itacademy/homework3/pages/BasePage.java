package org.itacademy.homework3.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.driver.DriverManager;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        PageFactory.initElements(DriverManager.getDriver(), this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='mainheader']//div[@class='hassubmenu']/*[contains(@href,'menu')]")
    private WebElement topHeaderMenu;

    @FindBy(xpath = "//*[@id='mainheader']//*[contains(@href,'places')]")
    private WebElement topHeaderAddresses;

    @FindBy(xpath = "//*[@id='mainheader']//*[contains(@href,'delivery')]")
    private WebElement topHeaderDelivery;

    public void topHeaderMenuClick() {
        WaitUtils.waitForVisibility(topHeaderMenu);
        topHeaderMenu.click();
    }

    public void topHeaderAddressesClick() {
        WaitUtils.waitForVisibility(topHeaderAddresses);
        topHeaderAddresses.click();
        WaitUtils.waitSeconds(2); // подождать посмотреть на результат поиска
    }

    public void topHeaderDeliveryClick() {
        WaitUtils.waitForVisibility(topHeaderDelivery);
        topHeaderDelivery.click();
        WaitUtils.waitSeconds(2); // подождать посмотреть на результат поиска
    }
}
