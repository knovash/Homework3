package org.itacademy.homework3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.pages.DeliveryPage;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DeliveryTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryTest.class);
    private DeliveryPage deliveryPage;

    @BeforeMethod
    public void beforemethod() {
        LOGGER.info("BEFORE METHOD get page " + Config.getPageDelivery());
        driver.get(Config.getPageDelivery());
        deliveryPage = new DeliveryPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @DataProvider(name = "addresses", parallel = false)
    public Object[][] addresses()
    {
        return new Object[][]{{"Кульман", "15"}, {"Богдановича", "10"}};
    }

    @Test(testName = "CheckDelivery", dataProvider = "addresses", description = "Verifys delivery addressses", enabled = true)
    public void verifyDeliveryTest(String street, String building) {
        LOGGER.info("TEST DELIVERY" + driver);
        deliveryPage.getFieldStreet().sendKeys(street);
        deliveryPage.getFieldBuilding().sendKeys(building);
        deliveryPage.clickButtonCheck();
        Boolean status = false;
        try {
            status = deliveryPage.getStatusSuccess().isDisplayed();
        } catch (NoSuchElementException e) {
            LOGGER.info("NO ELEMENT");
        }
        LOGGER.info("STATUS " + status);
        Assert.assertTrue(status, "NOT SUCCESS");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }

    @Test(testName = "NotTest", description = "Verifys nothing", enabled = true)
    public void verifyNothing() {
        LOGGER.info("TEST NOTHING");
        deliveryPage.topHeaderAddressesClick();
        WaitUtils.waitSeconds(2); // подождать посмотреть на результат поиска
        deliveryPage.topHeaderDeliveryClick();
        WaitUtils.waitSeconds(2); // подождать посмотреть на результат поиска
        deliveryPage.getFieldStreet().sendKeys("street");
        Assert.assertTrue(true, "NOT TRUE");
    }
}