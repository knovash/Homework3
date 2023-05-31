package org.itacademy.homework3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTestAll {

    private WebDriver driver;
    private DonerKing donerKing;

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
//        driver.get(Config.getTestPage());
    }

    @BeforeClass
    public void beforeclass() {
        donerKing = new DonerKing(driver);
        System.out.println("BEFORECLASS CLASS DRIVER " + driver);
//        driver.get(Config.getTestPage());
    }

    @BeforeMethod
    public void beforemethod() {
        driver = DriverManager.getDriver();
        System.out.println("BEFORE METHOD DRIVER " + driver);
        driver.get(Config.getTestPage());
        donerKing = new DonerKing(driver);
    }

    @Test(testName = "CheckSearch", dataProvider = "menuItems", description = "Verifys that search box works", enabled = true)
    public void verifySearchTest(String menuItem) {
        System.out.println("\n");
        System.out.println("TEST DRIVER " + menuItem + " " + driver);
        System.out.println("TEST DONERKING " + menuItem + " " + donerKing);

        donerKing.clickSearchButton();
        System.out.println("SEARCH FIELD DISPLAYED: " + donerKing.getSearchField().isDisplayed());
        donerKing.getSearchField().sendKeys(menuItem); // метод которые возвращает само поле поиска
        donerKing.clickSearchStartButton();

        // получить лист найденных элементов
        List<WebElement> items = donerKing.getSearchResultList();
        System.out.println("\nFOUND ITEMS CONTAINS: " + menuItem);
        System.out.println(items.isEmpty() + " " + items.size() + " " + items);
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(items.isEmpty(), "RESULT EMPTY");
        items.stream()
                .map(w -> w.getText().toLowerCase()) // из каждого найденного элемнта получаем текст
                // проверяем что текст элемента содержит искомый текст
                .peek(t -> sa.assertTrue(t.contains(menuItem), "ЭТО НЕ " + menuItem + " " + t))
                .forEach(System.out::println);
        sa.assertAll();

        // подождать посмотреть на результат поиска
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

