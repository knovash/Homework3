package org.itacademy.homework3;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.MenuItem;
import org.itacademy.homework3.steps.SearchSteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderSearch;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Log4j2
@Listeners
public class SearchTest extends BaseTest {

    private SearchSteps searchSteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageSearch());
        driver.get(Config.getPageSearch());
        searchSteps = new SearchSteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Description ("Search Menu Item and chech in in result items list")
    @Issue("wrong search results")
    @Test(testName = "CheckSearch",
            dataProvider = "menuItems",
            dataProviderClass = DataProviderSearch.class,
            description = "Verifys that search box works")
    public void verifySearchTest(MenuItem menuItem) {
        log.info("TEST SEARCH " + driver);
        searchSteps.clickSearchButton();
        searchSteps.enterSearchFieldText(menuItem.getName());
        searchSteps.clickSearchStartButton();
        Assert.assertTrue(searchSteps.getAssertResult(menuItem.getName()), "NOT SUCCESS");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }
}