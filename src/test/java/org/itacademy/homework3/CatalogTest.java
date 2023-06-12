package org.itacademy.homework3;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.steps.CatalogSteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderCatalog;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Log4j2
@Listeners
public class CatalogTest extends BaseTest {

    private CatalogSteps catalogSteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageOnliner());
        driver.get(Config.getPageOnliner());
        catalogSteps = new CatalogSteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Description("Search item in catalog and compare first 10 items")
    @Test(testName = "CheckCompare",
            dataProvider = "catalogitems",
            dataProviderClass = DataProviderCatalog.class,
            description = "Search item in catalog and compare first 10 items")
    public void verifyCatalogTest(CatalogItem item) {
        log.info("CheckCompare " + driver);
        catalogSteps.clickButtonCatalog();
        catalogSteps.enterFieldSearch(item.getName());
        catalogSteps.switchToFrame(driver);
        catalogSteps.clickCheckboxes();
        catalogSteps.clickCompare();
        Assert.assertTrue(catalogSteps.checkTitleCompare(),"Title compare not displayed");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат
    }

}