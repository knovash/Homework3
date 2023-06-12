package org.itacademy.homework3;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.driver.DriverManager;
import org.itacademy.homework3.steps.DeliverySteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Log4j2
@Listeners
public class DeliveryDelayTest extends BaseTest {

    private DeliverySteps deliverySteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageDelivery());
        driver.get(Config.getPageDelivery());
        deliverySteps = new DeliverySteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DataProvider(name = "delays", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] delays() // имя метода дата провайдера
    {
        return new Object[][]{{50}, {100}, {500}};
    }

    @Description("Verifys delay for address check")
    @Issue("delay for address check")
    @Test(testName = "Delay test",
            dataProvider = "delays",
            description = "Verifys delay for address check")
    public void verifyDeliveryTest(int time) {
        log.info("Delay test" + driver);
        deliverySteps.enterFieldStreet("Кульман");
        log.info("getFieldStreet " + deliverySteps.getFieldStreet());
        deliverySteps.enterFieldBuilding("15");
        deliverySteps.clickButtonCheck();
        log.info("TIMER " + time);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }

        Assert.assertEquals(deliverySteps.status(), "success", "not enough time to check the address.");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }
}