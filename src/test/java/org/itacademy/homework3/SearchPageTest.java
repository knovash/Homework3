package org.itacademy.homework3;

import org.itacademy.homework3.driver.DriverManager;
import org.itacademy.homework3.pages.SearchPage;
import org.itacademy.homework3.steps.steps.stepsSearch.StepGetResults;
import org.itacademy.homework3.steps.steps.stepsSearch.StepRunSearch;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchPageTest extends BaseTest{

    private SearchPage searchPage;

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
        searchPage = new SearchPage(driver);
    }

    @BeforeMethod
    public void beforemethod() {
        driver = DriverManager.getDriver();
        System.out.println("BEFORE METHOD DRIVER " + driver);
        driver.get(Config.getPageSearch());
        searchPage = new SearchPage(driver);
    }

    @Test(testName = "CheckSearch", dataProvider = "menuItems", description = "Verifys that search box works", enabled = true)
    public void verifySearchTest(String menuItem) {
        StepRunSearch.runSearch(searchPage, menuItem); // запустить поиск элемента меню
        List<WebElement> items = StepGetResults.get(searchPage); // получить лист найденных элементов

        System.out.println("\nFOUND ITEMS CONTAINS: " + menuItem);
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(items.isEmpty(), "RESULT EMPTY");
        items.stream()
                .map(w -> w.getText().toLowerCase()) // из каждого найденного элемнта получаем текст
                // проверяем что текст элемента содержит искомый текст
                .peek(t -> sa.assertTrue(t.contains(menuItem), "ЭТО НЕ " + menuItem + " " + t))
                .forEach(System.out::println);
        sa.assertAll();

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

