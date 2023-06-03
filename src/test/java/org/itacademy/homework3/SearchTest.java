package org.itacademy.homework3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.Address;
import org.itacademy.homework3.models.MenuItem;
import org.itacademy.homework3.pages.SearchPage;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SearchTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);
    private SearchPage searchPage;

    @DataProvider(name = "menuItems", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] menuItems() // имя метода дата провайдера
    {
        return new Object[][]{
                {new MenuItem("донер")},
                {new MenuItem("бургер")}
        };
    }

    @BeforeMethod
    public void beforemethod() {
        LOGGER.info("BEFORE METHOD get page " + Config.getPageSearch());
        driver.get(Config.getPageSearch());
        searchPage = new SearchPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(testName = "CheckSearch", dataProvider = "menuItems", description = "Verifys that search box works", enabled = true)
    public void verifySearchTest(MenuItem menuItem) {
        LOGGER.info("TEST SEARCH" + driver);
        searchPage.clickSearchButton();
        LOGGER.info("SEARCH FIELD DISPLAYED: " + searchPage.getSearchField().isDisplayed());
        searchPage.getSearchField().sendKeys(menuItem.getName());
        searchPage.clickSearchStartButton();
        List<WebElement> items = searchPage.getSearchResultList();

        LOGGER.info("\nFOUND ITEMS CONTAINS: " + menuItem);
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(items.isEmpty(), "RESULT EMPTY");
        items.stream()
                .map(w -> w.getText().toLowerCase()) // из каждого найденного элемнта получаем текст
                // проверяем что текст элемента содержит искомый текст
                .peek(t -> sa.assertTrue(t.contains(menuItem.getName()), "ЭТО НЕ " + menuItem.getName() + " " + t))
                .forEach(System.out::println);
        sa.assertAll();
        WaitUtils.waitSeconds(2); // подождать посмотреть на результат поиска
    }
}