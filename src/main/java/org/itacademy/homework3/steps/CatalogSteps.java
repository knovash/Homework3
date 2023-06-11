package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.pages.CatalogPage;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class CatalogSteps {

    private CatalogPage catalogPage; // создаем поле пэйджи

    // конструктор создания класса степов
    public CatalogSteps(WebDriver driver) {
        catalogPage = new CatalogPage(driver);
    }

    // методы из пэйджи

    public void clickButttonCatalog() {
        WaitUtils.waitForVisibility(catalogPage.getButtonCatalog());
        log.info("DISPLAYED getButtonCatalog: " + catalogPage.getButtonCatalog().isDisplayed());
        catalogPage.getButtonCatalog().click();
    }

    public void enterFieldSearch(String text) {
        WaitUtils.waitForVisibility(catalogPage.getFieldFastSearch());
        log.info("DISPLAYED getFieldSearch: " + catalogPage.getFieldFastSearch().isDisplayed());
        log.info("HTML getFieldSearch: " + catalogPage.getFieldFastSearch().getAttribute("outerHTML"));
        catalogPage.getFieldFastSearch().sendKeys(text);
    }

    public String getValueFieldFastSearch() {
        WaitUtils.waitForVisibility(catalogPage.getFieldFastSearch());
        log.info("DISPLAYED getFieldSearch: " + catalogPage.getFieldFastSearch().isDisplayed());
        return catalogPage.getFieldFastSearch().getAttribute("value");
    }

    public String getValueFieldSearch() {
        WaitUtils.waitForVisibility(catalogPage.getFieldSearch());
        log.info("DISPLAYED getFieldSearch: " + catalogPage.getFieldSearch().isDisplayed());
        return catalogPage.getFieldSearch().getAttribute("value");
    }

    public List<WebElement> getProductDescriptions() {
//        WaitUtils.waitForVisibility(catalogPage.getProductDescription());
//        log.info("DISPLAYED getFieldSearch: " + catalogPage.getProductDescription().isDisplayed());
        return catalogPage.getProductDescription();
    }


    public WebElement getResultActive() {
        WaitUtils.waitForVisibility(catalogPage.getResultActive());
        log.info("DISPLAYED getResultActive: " + catalogPage.getResultActive().isDisplayed());
        return catalogPage.getResultActive();
    }

    public void clickResultActive() {
        WaitUtils.waitForVisibility(catalogPage.getResultActive());
        log.info("DISPLAYED getResultActive: " + catalogPage.getResultActive().isDisplayed());
        log.info("HTML getResultActive: " + catalogPage.getResultActive().getAttribute("outerHTML"));
        catalogPage.getResultActive().click();
    }

    public void clickInNews() {
        WaitUtils.waitForVisibility(catalogPage.getButtonInNews());
        log.info("DISPLAYED getButtonInNews: " + catalogPage.getButtonInNews().isDisplayed());
        log.info("HTML getButtonInNews: " + catalogPage.getButtonInNews().getAttribute("outerHTML"));
        catalogPage.getButtonInNews().click();
    }

    public WebElement getIframe() {
        WaitUtils.waitForVisibility(catalogPage.getIframe());
        log.info("DISPLAYED getButtonInNews: " + catalogPage.getIframe().isDisplayed());
        log.info("HTML getButtonInNews: " + catalogPage.getIframe().getAttribute("outerHTML"));
        return catalogPage.getIframe();
    }

    public void clickCheckbox() {
        WaitUtils.waitForVisibility(catalogPage.getCheckbox());
        log.info("DISPLAYED getButtonInNews: " + catalogPage.getCheckbox().isDisplayed());
        log.info("HTML getButtonInNews: " + catalogPage.getCheckbox().getAttribute("outerHTML"));
        catalogPage.getCheckbox().click();
    }

    public void clickCheckboxs() {
        WaitUtils.waitForVisibility(catalogPage.getCheckbox());
        log.info("DISPLAYED getButtonInNews: " + catalogPage.getCheckbox().isDisplayed());
        log.info("HTML getButtonInNews: " + catalogPage.getCheckbox().getAttribute("outerHTML"));
        catalogPage.getCheckboxs().stream().forEach(webElement -> webElement.click());
    }

    public void clickCompare() {
        WaitUtils.waitForVisibility(catalogPage.getButtonCompare());
        log.info("DISPLAYED getButtonInNews: " + catalogPage.getButtonCompare().isDisplayed());
        log.info("HTML getButtonInNews: " + catalogPage.getButtonCompare().getAttribute("outerHTML"));
        catalogPage.getButtonCompare().click();
    }




}
