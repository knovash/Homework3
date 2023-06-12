package org.itacademy.homework3;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.pages.CatalogElement;
import org.itacademy.homework3.steps.CatalogElementSteps;
import org.itacademy.homework3.steps.CatalogSteps;
import org.itacademy.homework3.utils.CatalogItemsToJSON;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.DataProviderCatalog;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.SearchContext;
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
    private CatalogElementSteps catalogElementSteps;

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

    @Description("list to json")
    @Test(testName = "CheckCompare",
            dataProvider = "item")
    public void verifyCatalogTest(String item) {
        log.info("CheckCompare " + driver);
        catalogSteps.clickButtonCatalog();
        catalogSteps.enterFieldSearch(item);
        catalogSteps.switchToFrame(driver);
        List<WebElement> webList = catalogSteps.getListResultElements();

        List<CatalogElement> listCatEl =
                webList.stream()
                        .peek(x1 -> System.out.println("WEB " + x1.getAttribute("outerHTML")))
                        .map(webElement -> new CatalogElement(webElement, driver))
                        .collect(Collectors.toList());

        listCatEl.stream()
                .forEach(x -> {
                    log.info(x.getProductTitle().getText());
                    log.info(x.getProductPrice().getText());
                    log.info(x.getProductOffers().getText());
                });
//
//        List<CatalogItem> objList = catalogElementSteps.webListToObjectList(listCatEl);
//
//
//        CatalogItemsToJSON.toJson(objList, "src/main/resources/data/catalogitems.json");

//
////        List<CatalogItem> objList = catalogSteps.webListToObjectList(webList);
//        log.info("CATALOG ITEM OBJECTS LIST");
//        objList.stream().forEach(catalogItem -> log.info(catalogItem));
//        CatalogItemsToJSON.toJson(objList, "src/main/resources/data/catalogitems.json");
//        Assert.assertTrue(catalogSteps.checkTitleCompare(),"Title compare not displayed");
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат
    }
}