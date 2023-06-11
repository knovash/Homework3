package org.itacademy.homework3;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.steps.CatalogSteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderCatalog;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
            dataProvider = "items",
            dataProviderClass = DataProviderCatalog.class,
            description = "Verifys catalog search", enabled = true)
    public void verifyCatalogTest(CatalogItem item) {
        log.info("TEST CATALOG" + driver);
        SoftAssert sa = new SoftAssert();
        catalogSteps.clickButttonCatalog();
        catalogSteps.enterFieldSearch(item.getName());

        WebElement frame = catalogSteps.getIframe();
        driver.switchTo().frame(frame);

        log.info("SEARCH VALUE" + catalogSteps.getValueFieldSearch());
        sa.assertEquals(catalogSteps.getValueFieldSearch(), item.getName());
        catalogSteps.clickCheckboxs();
        catalogSteps.clickCompare();
        sa.assertAll();
//        Assert.assertEquals(catalogSteps.getValueFieldSearch(), item.getName(), "VALUE NOT EQUAL " + item.getName());
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }

}