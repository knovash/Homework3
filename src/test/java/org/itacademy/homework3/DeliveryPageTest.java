package org.itacademy.homework3;

import org.itacademy.homework3.driver.DriverManager;
import org.itacademy.homework3.pages.DeliveryPage;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DeliveryPageTest extends BaseTest{

    private DeliveryPage deliveryPage;

    @BeforeTest
    public void beforetest() {
        driver = DriverManager.getDriver();
    }

    @BeforeClass
    public void beforeclass() {
        deliveryPage = new DeliveryPage(driver);
    }

    @BeforeMethod
    public void beforemethod() {
        driver = DriverManager.getDriver();
        System.out.println("BEFORE METHOD DRIVER " + driver);
        driver.get(Config.getPageDelivery());
        deliveryPage = new DeliveryPage(driver);
    }
    @DataProvider(name = "addresses", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] addresses() // имя метода дата провайдера
    {
        return new Object[][]{{"Кульман", "15"}, {"Богдановича", "10"},  {"влавыав", "10"}, };
    }

    @Test(testName = "CheckDelivery", dataProvider = "addresses", description = "Verifys delivery addressses", enabled = true)
    public void verifyDeliveryTest(String street, String building) {
        deliveryPage.getFieldStreet().sendKeys(street);
        deliveryPage.getFieldBuilding().sendKeys(building);
        deliveryPage.clickButtonCheck();

        Boolean status = false;
        try {
            status = deliveryPage.getStatusSuccess().isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("NO ELEMENT");
        }
        System.out.println("STATUS " + status);
        Assert.assertTrue(status,"NOT SUCCESS");
        WaitUtils.waitSeconds(5); // подождать посмотреть на результат поиска
    }

    @AfterMethod // выполниться после каждого элемента дата провайдера
    public void aftermethod() {
        System.out.println("AFTER METHOD");
        DriverManager.quitDriver();
    }

    @AfterClass
    public void afterclass() {
        System.out.println("AFTER CLASS");
    }

    @AfterTest
    public void aftertest() {
        System.out.println("AFTER TEST");
    }
}

