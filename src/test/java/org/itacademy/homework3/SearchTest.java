package org.itacademy.homework3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.models.Menu;
import org.itacademy.homework3.models.MenuItem;
import org.itacademy.homework3.pages.SearchPage;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.GetData;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);
    private SearchPage searchPage;

    @DataProvider(name = "menuItems", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] menuItems() // имя метода дата провайдера
    {
        Menu menu = GetData.get();
        int menuSize = menu.getItems().size();
        Object[][] arr = new Object[menuSize][1];
        for (int i=0; i< menuSize; i++){
            arr[i][0] = menu.getItems().get(i);
            LOGGER.info("ARR " + arr[i][0]);
        }
        return arr;
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
        LOGGER.info("TEST SEARCH " + driver);
        searchPage.clickSearchButton();
        searchPage.enterSearchFieldText(menuItem.getName());
        searchPage.clickSearchStartButton();
        Assert.assertTrue(searchPage.getAssertResult(menuItem.getName()), "NOT SUCCESS");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }
}