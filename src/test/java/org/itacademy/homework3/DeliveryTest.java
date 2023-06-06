package org.itacademy.homework3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.Address;
import org.itacademy.homework3.pages.DeliveryPage;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderDelivery;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeliveryTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryTest.class);
    private DeliveryPage deliveryPage;

    @BeforeMethod
    public void beforemethod() {
        LOGGER.info("BEFORE METHOD get page " + Config.getPageDelivery());
        driver.get(Config.getPageDelivery());
        deliveryPage = new DeliveryPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @DataProvider(name = "addresses", parallel = false)
//    public Object[][] addresses() {
//        return new Object[][]{
//                {new Address("Кульман", "15")},
//                {new Address("Богдановича", "10")}
//        };
//    }

    @Test(testName = "CheckDelivery",
            dataProvider = "addresses",
            dataProviderClass = DataProviderDelivery.class,
            description = "Verifys delivery addressses")
    public void verifyDeliveryTest(Address address) {
        LOGGER.info("TEST DELIVERY" + driver);
        deliveryPage.enterFieldStreet(address.getStreet());
        deliveryPage.enterFieldBuilding(address.getBuilding());
        deliveryPage.clickButtonCheck();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String status = deliveryPage.status().getAttribute("class");
        LOGGER.info("----status: " + status);
        Assert.assertEquals(status, "success", "NOT SUCCESS wrong address " + address.getBuilding());
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }

    @Test(testName = "NotTest", description = "Verifys nothing", enabled = true)
    public void verifyNothing() {
        LOGGER.info("TEST NOTHING");
        deliveryPage.topHeaderAddressesClick();
        deliveryPage.topHeaderDeliveryClick();
        deliveryPage.enterFieldBuilding("street");
        Assert.assertTrue(true, "NOT TRUE");
    }
}