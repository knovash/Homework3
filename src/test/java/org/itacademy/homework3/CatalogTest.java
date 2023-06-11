package org.itacademy.homework3;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.steps.CatalogSteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderCatalog;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Log4j2
public class CatalogTest extends BaseTest {

    private CatalogSteps catalogSteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageOnliner());
        driver.get(Config.getPageOnliner());
        catalogSteps = new CatalogSteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(testName = "CheckCatalog",
            dataProvider = "items",
            dataProviderClass = DataProviderCatalog.class,
            description = "Verifys catalog addressses", enabled = false)
    public void verifyCatalogTest(CatalogItem item) {
        log.info("TEST CATALOG" + driver);
        catalogSteps.clickButttonCatalog();
        catalogSteps.enterFieldSearch(item.getName());
        log.info("VALUE " + catalogSteps.getValueFieldSearch());
        Assert.assertEquals(catalogSteps.getValueFieldSearch(), item.getName(), "VALUE NOT EQUAL " + item.getName());
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }

}