package org.itacademy.homework3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='b-main-navigation__text']")
    private WebElement buttonCatalog;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private WebElement fieldSearch;

    public WebElement getButtonCatalog() {
        return buttonCatalog;
    }

    public WebElement getFieldSearch() {
        return fieldSearch;
    }
}