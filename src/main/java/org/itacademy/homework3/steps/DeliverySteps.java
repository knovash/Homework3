package org.itacademy.homework3.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.pages.DeliveryPage;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliverySteps {

    private DeliveryPage deliveryPage; // создаем поле пэйджи
    private static final Logger LOGGER = LogManager.getLogger(DeliverySteps.class);

    // конструктор создания класса степов
    public DeliverySteps(WebDriver driver) {
        deliveryPage = new DeliveryPage(driver);
    }

    // методы из пэйджи

    public void enterFieldStreet(String street) {
        deliveryPage.getFieldStreet().sendKeys(street);
    }

    public void enterFieldBuilding(String building) {
        deliveryPage.getFieldBuilding().sendKeys(building);
    }

    public void clickButtonCheck() {

        WaitUtils.waitForVisibility(deliveryPage.getButtonCheck());
        deliveryPage.getButtonCheck().click();
    }

    public String status() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String status = deliveryPage.getStatus().getAttribute("class");
        LOGGER.info("STATUS: " + status);
        return status;
    }

}
