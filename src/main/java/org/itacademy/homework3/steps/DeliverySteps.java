package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.pages.DeliveryPage;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DeliverySteps {

    private DeliveryPage deliveryPage; // создаем поле пэйджи

    // конструктор создания класса степов
    public DeliverySteps(WebDriver driver) {
        deliveryPage = new DeliveryPage(driver);
    }

    // методы из пэйджи

    public void enterFieldStreet(String street) {
        WaitUtils.waitForVisibility(deliveryPage.getFieldStreet());
        deliveryPage.getFieldStreet().sendKeys(street);
    }

    public String getFieldStreet() {
        WaitUtils.waitForVisibility(deliveryPage.getFieldStreet());
//        getAttribute("value")
//        return deliveryPage.getFieldStreet().getText();
        return deliveryPage.getFieldStreet().getAttribute("value");
    }

    public void enterFieldBuilding(String building) {
        WaitUtils.waitForVisibility(deliveryPage.getFieldBuilding());
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
//        WaitUtils.waitForVisibility(deliveryPage.getStatus()); // недостаточно вэйт визибилити. нужен слип
        String status = deliveryPage.getStatus().getAttribute("class");
        log.info("STATUS: " + status);
        return status;
    }
}
