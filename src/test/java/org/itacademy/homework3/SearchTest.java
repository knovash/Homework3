package org.itacademy.homework3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.MenuItem;
import org.itacademy.homework3.pages.SearchPage;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderJSON;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);
    private SearchPage searchPage;

// дата провайдер переносится в JsonReader класс
//    @DataProvider(name = "menuItems", parallel = false) // если нет имени то определяется по имени метода

    @BeforeMethod
    public void beforemethod() {
        LOGGER.info("BEFORE METHOD get page " + Config.getPageSearch());
        driver.get(Config.getPageSearch());
        searchPage = new SearchPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @Test(testName = "CheckSearch", dataProvider = "menuItems", description = "Verifys that search box works", enabled = true)
// добавлен  dataProviderClass = JsonReader.class
    @Test(testName = "CheckSearch", dataProvider = "menuItems",  dataProviderClass = DataProviderJSON.class, description = "Verifys that search box works", enabled = true)
    // MenuItem класс заменен на ItemLombok
    public void verifySearchTest(MenuItem menuItem) {
        LOGGER.info("TEST SEARCH " + driver);
        searchPage.clickSearchButton();
        searchPage.enterSearchFieldText(menuItem.getName());
        searchPage.clickSearchStartButton();
        Assert.assertTrue(searchPage.getAssertResult(menuItem.getName()), "NOT SUCCESS");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }
}