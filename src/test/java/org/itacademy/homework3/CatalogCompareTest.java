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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Log4j2
@Listeners
public class CatalogCompareTest extends BaseTest {

    private CatalogSteps catalogSteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageOnliner());
        driver.get(Config.getPageOnliner());
        catalogSteps = new CatalogSteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DataProvider(name = "item", parallel = false) // если нет имени то определяется по имени метода
    public Object[][] item() // имя метода дата провайдера
    {
        return new Object[][]{{"iphone 12"}};
    }

    @Description("Search item in catalog and compare first 10 items")
    @Test(testName = "CheckCompare",
            dataProvider = "item",
            description = "Search item in catalog and compare first 10 items")
    public void verifyCatalogTest(String item) {
        log.info("CheckCompare " + driver);
        catalogSteps.clickButtonCatalog();
        catalogSteps.enterFieldSearch(item);
        catalogSteps.switchToFrame(driver);
        catalogSteps.clickCheckboxes();
        catalogSteps.clickCompare();
        Assert.assertTrue(catalogSteps.checkTitleCompare(),"Title compare not displayed");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат
    }

}