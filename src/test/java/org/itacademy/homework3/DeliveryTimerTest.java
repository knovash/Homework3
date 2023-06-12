package org.itacademy.homework3;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.Address;
import org.itacademy.homework3.steps.DeliverySteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderDelivery;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Log4j2
@Listeners
public class DeliveryTimerTest extends BaseTest {

    private DeliverySteps deliverySteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageDelivery());
        driver.get(Config.getPageDelivery());
        deliverySteps = new DeliverySteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DataProvider(name = "timers", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] addresses() // имя метода дата провайдера
    {
        return new Object[][]{{10}, {50}, {100}, {500}};
    }

    @Description("@ Verifys time for show address check")
    @Issue("dont show reasult")
    @Test(testName = "timers",
            dataProvider = "timers",
            description = "Verifys time for show address check", enabled = true)
    public void verifyDeliveryTest(int time) {
        log.info("TEST DELIVERY" + driver);
        deliverySteps.enterFieldStreet("Кульман");
        log.info("GET TEXT getFieldStreet " + deliverySteps.getFieldStreet());
        deliverySteps.enterFieldBuilding("15");
        deliverySteps.clickButtonCheck();
        log.info("TIMER " + time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
        String result = deliverySteps.status();
        Assert.assertEquals(result, "success", "not enough time to check the address.");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }
}