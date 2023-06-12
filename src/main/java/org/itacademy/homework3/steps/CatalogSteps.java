package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.CatalogItem;
import org.itacademy.homework3.pages.CatalogElement;
import org.itacademy.homework3.pages.CatalogPage;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class CatalogSteps {

    private CatalogPage catalogPage;

    public CatalogSteps(WebDriver driver) {
        catalogPage = new CatalogPage(driver);
    }

    public void clickButtonCatalog() {
        log.info("getButtonCatalog click");
        WaitUtils.waitForVisibility(catalogPage.getButtonCatalog());
        catalogPage.getButtonCatalog().click();
    }

    public void enterFieldSearch(String text) {
        log.info("getFieldFastSearch");
        WaitUtils.waitForVisibility(catalogPage.getFieldFastSearch());
        log.info("HTML getFieldFastSearch " + catalogPage.getFieldFastSearch().getAttribute("outerHTML"));
        catalogPage.getFieldFastSearch().sendKeys(text);
    }

    public void switchToFrame(WebDriver driver) {
        log.info("getIframe switchTo");
        WebElement frame = catalogPage.getIframe();
        driver.switchTo().frame(frame);
    }

    public void clickCheckboxes() {
        log.info("getCheckbox click");
        WaitUtils.waitForVisibility(catalogPage.getCheckbox());
        catalogPage.getCheckboxes().stream().forEach(checkbox -> checkbox.click());
        WaitUtils.waitSeconds(2);
    }

    public void clickCompare() {
        log.info("getButtonCompare click");
        WaitUtils.waitForVisibility(catalogPage.getButtonCompare());
        catalogPage.getButtonCompare().click();
    }

    public Boolean checkTitleCompare() {
        log.info("getTitleCompare isDisplayed");
        WaitUtils.waitForVisibility(catalogPage.getTitleCompare());
        return catalogPage.getTitleCompare().isDisplayed();
    }

    public List<WebElement> getListResultElements() {
        log.info("getButtonCompare click");
        return catalogPage.getListSearchResultElements();
    }


}
