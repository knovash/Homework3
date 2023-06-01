package org.itacademy.homework3;

import org.itacademy.homework3.driver.DriverManager;
import org.itacademy.homework3.pages.DeliveryPage;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DeliveryPageTest extends BaseTest {

    private DeliveryPage deliveryPage;

    @BeforeClass
    public void beforeclass() {
//        driver = DriverManager.getDriver(); // достаточно создать в бефо тест
        System.out.println("\nBEFORE CLASS DRIVER (in test) " + driver);
        // для этого класса понижаем ожидание чтоб долго неждать если адрес ненайден
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get(Config.getPageDelivery());
//        deliveryPage = new DeliveryPage(driver);
    }


    @BeforeMethod
    public void beforemethod() {
//        driver = DriverManager.getDriver(); // достаточно создать в бефо класс
        System.out.println("\nBEFORE METHOD DRIVER (in test) " + driver);
        driver.get(Config.getPageDelivery());
        deliveryPage = new DeliveryPage(driver); // обновляет браузер чтоб ввести в пустые поля
        // перед каждым запуском метода с новым элементом датапровайдера
    }

    @DataProvider(name = "addresses", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] addresses() // имя метода дата провайдера
    {
        return new Object[][]{{"Кульман", "15"}, {"Богдановича", "10"}};
    }

    @Test(testName = "CheckDelivery", dataProvider = "addresses", description = "Verifys delivery addressses", enabled = true)
    public void verifyDeliveryTest(String street, String building) {
        System.out.println("\nTEST DELIVERY");
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
        Assert.assertTrue(status, "NOT SUCCESS");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }

    @Test(testName = "NotTest", description = "Verifys nothing", enabled = true)
    public void verifyNothing() {
        System.out.println("\nTEST NOTHING");
        deliveryPage.getFieldStreet().sendKeys("street");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
        Assert.assertTrue(true, "NOT TRUE");
    }
}

