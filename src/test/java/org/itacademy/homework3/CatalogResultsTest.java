package org.itacademy.homework3;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.pages.CatalogElement;
import org.itacademy.homework3.steps.CatalogSteps;
import org.itacademy.homework3.utils.CatalogItemsToJSON;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Listeners
public class CatalogResultsTest extends BaseTest {

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

    @Description("Results to WebElements to CatalogElements to Objects to JSON")
    @Test(testName = "ResultsToFile",
            dataProvider = "item")
    public void verifyCatalogTest(String item) {
        log.info("CheckCompare " + driver);
        catalogSteps.clickButtonCatalog();
        catalogSteps.enterFieldSearch(item);
        catalogSteps.switchToFrame(driver);

        // search results to WebElements list
        List<WebElement> webList = catalogSteps.getSearchResults();

        // to CatalogElements (WebElements) list
        List<CatalogElement> catList = webList.stream()
                .map(webElement -> new CatalogElement(webElement, driver))
                .collect(Collectors.toList());

        // to CatalogItem objects list (title,price,offers)
        List<CatalogItem> objList = catalogSteps.webelementsToObjects(catList);

        log.info("\nCATALOG ITEM OBJECTS LIST");
        objList.stream().forEach(catalogItem -> log.info("\n" + catalogItem));

        // to JSON file
        CatalogItemsToJSON.toJson(objList, "src/main/resources/data/catalogitems.json");

        Assert.assertTrue(true,"xxx");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат
    }
}