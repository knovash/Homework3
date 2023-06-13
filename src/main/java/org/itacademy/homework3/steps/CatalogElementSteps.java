package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.pages.CatalogElement;
import org.itacademy.homework3.pages.CatalogPage;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class CatalogElementSteps {

    private CatalogElement catalogElement;

//    public CatalogElementSteps(WebDriver driver) {
//        catalogElement = new CatalogElement((WebElement) driver);
//    }

//    public String getTitle(CatalogElement element) {
//        return element.getProductTitle().getText();
//    }
//
//    public String getPrice(CatalogElement element) {
//        return element.getProductPrice().getText();
//    }
//
//    public String getOffers(CatalogElement element) {
//        return element.getProductOffers().getText();
//    }
//
//
//    public CatalogItem elementToObject(CatalogElement topElement) {
//        CatalogItem object = new CatalogItem();
//        log.info("CONTEXT: " + topElement);
//        CatalogElement context = topElement;
//        object.setPrice(getTitle(context));
//        object.setPrice(getPrice(context));
//        object.setOffers(getOffers(context));
//
//        log.info(object);
//        return object;
//    }
//
//    public List<CatalogItem> webListToObjectList(List<CatalogElement> list) {
//        List<CatalogItem> listCatalogItems = list.stream()
//                .map(webElement -> elementToObject(webElement))
//                .collect(Collectors.toList());
//        return listCatalogItems;
//    }

}
