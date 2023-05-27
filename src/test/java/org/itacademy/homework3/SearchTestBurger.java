package org.itacademy.homework3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTestBurger {

    @BeforeTest
    public static void beforetest() {
        System.out.println("BEFORE TEST burger");
        Config.getProperties();
    }

    @BeforeClass
    public static void beforeclass() {
        System.out.println("BEFORE CLASS burger");
    }

    @BeforeSuite
    public static void beforesuite() {
        System.out.println("BEFORE SUITE burger");
    }

    @BeforeMethod
    public static void beforemethod() {
        System.out.println("BEFORE METHOD burger");
    }

    @Test(testName = "CheckSearch", description = "Verifys that search box works", enabled = true)
    public void verifySearchTest() {
        System.setProperty("webdriver.chrome.driver", Config.getChromeDriver());
        WebDriver driver = new ChromeDriver();
        driver.get(Config.getTestPage());
        DonerKing donerKing = new DonerKing(driver);
        SoftAssert sa = new SoftAssert();

        String menuItem = "бургер";
        donerKing.clickSearchButton();
        donerKing.getSearchField().sendKeys(menuItem); // метод которые возвращает само поле поиска
        donerKing.getSearchField().submit();

        // получить лист найденных элементов
        List<WebElement> items = donerKing.getSearchResultList();
        System.out.println("\nFOUND ITEMS CONTAINS: " + menuItem);
        System.out.println(items.isEmpty() + " " + items.size() + " " + items);
        sa.assertFalse(items.isEmpty(), "RESULT EMPTY");
        items.stream()
                .map(w -> w.getText().toLowerCase()) // из каждого найденного элемнта получаем текст
                // проверяем что текст элемента содержит искомый текст
                .peek(t -> sa.assertTrue(t.contains(menuItem), "ЭТО НЕ " + menuItem + " " + t))
                .forEach(System.out::println);
        sa.assertAll();

        // подождать посмотреть на результат поиска
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit(); // закрыть драйвер и браузер. close закроет окно но не драйвер
    }

    @AfterTest
    public static void closeBrowser() {
        System.out.println("AFTER TEST");
    }
}
