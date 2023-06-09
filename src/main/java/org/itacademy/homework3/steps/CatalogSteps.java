package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.pages.CatalogPage;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;

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
        WaitUtils.waitForVisibility(catalogPage.getFieldSearch());
        log.info("DISPLAYED getFieldSearch: " + catalogPage.getFieldSearch().isDisplayed());
        catalogPage.getFieldSearch().sendKeys(text);
    }

    public String getValueFieldSearch() {
        WaitUtils.waitForVisibility(catalogPage.getFieldSearch());
        log.info("DISPLAYED getFieldSearch: " + catalogPage.getFieldSearch().isDisplayed());
        return catalogPage.getFieldSearch().getAttribute("value");
    }

}
