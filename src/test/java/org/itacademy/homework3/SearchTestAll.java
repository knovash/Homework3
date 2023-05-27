package org.itacademy.homework3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTestAll {

    @BeforeTest
    public static void beforetest() {
        System.out.println("BEFORE TEST");
        Config.getProperties();
    }

    @BeforeClass
    public static void beforeclass() {
        System.out.println("BEFORE CLASS");
    }

    @BeforeSuite
    public static void beforesuite() {
        System.out.println("BEFORE SUITE");
    }

    @BeforeMethod
    public static void beforemethod() {
        System.out.println("BEFORE METHOD");
    }

    // дата провайдер - отдельный метод который возвращает матрицу обжектов
    @DataProvider(name = "menuItems", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] menuItems() // имя метода дата провайдера
    {
        return new Object[][]{{"донер"}, {"бургер"}, {"акваланг"}, {"пончики"}};
    }

    @Test(testName = "CheckSearch", dataProvider = "menuItems", description = "Verifys that search box works", enabled = true)
    public void verifySearchTest(String menuItem) {
        System.setProperty("webdriver.chrome.driver", Config.getChromeDriver());
        WebDriver driver = new ChromeDriver();
        driver.get(Config.getTestPage());
        DonerKing donerKing = new DonerKing(driver);
        SoftAssert sa = new SoftAssert();

        driver.manage().window().maximize();
        donerKing.clickSearchButton();
        System.out.println("SEARCH FIELD DISPLAYED: " + donerKing.getSearchField().isDisplayed());

        donerKing.getSearchField().sendKeys(menuItem); // метод которые возвращает само поле поиска
        donerKing.clickSearchStartButton(); // метод нажать кнопку Искать. КАК ЛУЧШЕ ?
//            donerKing.getSearchField().submit(); // метод выполнить поле поиска. КАК ЛКЧЩЕ ?

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
