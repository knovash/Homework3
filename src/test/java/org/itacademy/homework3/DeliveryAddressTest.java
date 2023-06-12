package org.itacademy.homework3;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.Address;
import org.itacademy.homework3.steps.DeliverySteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderDelivery;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Log4j2
public class DeliveryAddressTest extends BaseTest {

    private DeliverySteps deliverySteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageDelivery());
        driver.get(Config.getPageDelivery());
        deliverySteps = new DeliverySteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(testName = "CheckDelivery",
            dataProvider = "addresses",
            dataProviderClass = DataProviderDelivery.class,
            description = "Verifys delivery addressses", enabled = true)
    public void verifyDeliveryTest(Address address) {
        log.info("TEST DELIVERY" + driver);
        deliverySteps.enterFieldStreet(address.getStreet());
        log.info("GET TEXT getFieldStreet " + deliverySteps.getFieldStreet());
        deliverySteps.enterFieldBuilding(address.getBuilding());
        deliverySteps.clickButtonCheck();
//        WaitUtils.waitSeconds(1);
        String result = deliverySteps.status();
        Assert.assertEquals(result, "success", "NOT SUCCESS wrong address " + address.getBuilding());
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }
}