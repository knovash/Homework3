package org.itacademy.homework3;

import org.itacademy.homework3.driver.DriverManager;
import org.itacademy.homework3.pages.Delivery;
import org.itacademy.homework3.pages.MainSearch;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DeliveryTest {

    private WebDriver driver;
    private Delivery delivery;

    // дата провайдер - отдельный метод который возвращает матрицу обжектов
    @DataProvider(name = "menuItems", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] menuItems() // имя метода дата провайдера
    {
        return new Object[][]{{"донер"}, {"бургер"}};
    }

    @BeforeTest
    public void beforetest() {
        driver = DriverManager.getDriver();
        System.out.println("BEFORE TEST DRIVER " + driver);
    }

    @BeforeClass
    public void beforeclass() {
        delivery = new Delivery(driver);
        System.out.println("BEFORECLASS CLASS DRIVER " + driver);
    }

    @BeforeMethod
    public void beforemethod() {
        driver = DriverManager.getDriver();
        System.out.println("BEFORE METHOD DRIVER " + driver);
        driver.get(Config.getPageDelivery());
        delivery = new Delivery(driver);
    }

    @Test(testName = "checkAddress", description = "Verifys that address check works", enabled = true)
    public void verifyAddressTest(String menuItem) {
        delivery.getFieldCity().sendKeys("Minsk");
        delivery.getFieldStreet().sendKeys("Kulman");
        delivery.getFieldBuilding().sendKeys("15");
        WaitUtils.waitSeconds(3);
    }

    @AfterMethod // выполниться после каждого элеента дата провайдера
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

