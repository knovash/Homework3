package org.itacademy.homework3;

import org.itacademy.homework3.driver.DriverManager;
import org.itacademy.homework3.pages.MainSearch;
import org.itacademy.homework3.steps.StepCheckResults;
import org.itacademy.homework3.steps.StepGetResults;
import org.itacademy.homework3.steps.StepRunSearch;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class SearchAllTest {

    private WebDriver driver;
    private MainSearch mainSearch;

    // дата провайдер - отдельный метод который возвращает матрицу обжектов
    @DataProvider(name = "menuItems", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] menuItems() // имя метода дата провайдера
    {
        return new Object[][]{{"донер"}, {"бургер"}};
    }

    @BeforeTest
    public void beforetest() {
        driver = DriverManager.getDriver();
    }

    @BeforeClass
    public void beforeclass() {
        mainSearch = new MainSearch(driver);
    }

    @BeforeMethod
    public void beforemethod() {
        driver = DriverManager.getDriver();
        System.out.println("BEFORE METHOD DRIVER " + driver);
        driver.get(Config.getPageSearch());
        mainSearch = new MainSearch(driver);
    }

    @Test(testName = "CheckSearch", dataProvider = "menuItems", description = "Verifys that search box works", enabled = true)
    public void verifySearchTest(String menuItem) {
        StepRunSearch.runSearch(mainSearch, menuItem); // запустить поиск элемента меню
        List<WebElement> items = StepGetResults.get(mainSearch); // получить лист найденных элементов
        StepCheckResults.check(mainSearch, items, menuItem);
        WaitUtils.waitSeconds(2); // подождать посмотреть на результат поиска
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

