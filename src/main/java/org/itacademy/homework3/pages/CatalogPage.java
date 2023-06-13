package org.itacademy.homework3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends BasePage {

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='b-main-navigation__text']")
    private WebElement buttonCatalog;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private WebElement fieldFastSearch;

    @FindBy(xpath = "//iframe[@class='modal-iframe']")
    private WebElement iframe;

    @FindBy(xpath = "//span[@class='i-checkbox__faux']")
    private WebElement checkbox;

    @FindBy(xpath = "//span[@class='i-checkbox__faux']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//div[@class='compare-button compare-button_visible']")
    private WebElement buttonCompare;

    @FindBy(xpath = "//*[@class='b-offers-title' and text()='Сравнение товаров']")
    private WebElement titleCompare;

    @FindBy(xpath = "//*[@class='search__result']")
    private List<WebElement> listSearchResultElements;



    public WebElement getButtonCatalog() {
        return buttonCatalog;
    }

    public WebElement getFieldFastSearch() {
        return fieldFastSearch;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public WebElement getButtonCompare() {
        return buttonCompare;
    }

    public WebElement getTitleCompare() {
        return titleCompare;
    }

    public List<WebElement> getSearchResultElements() {
        return listSearchResultElements;
    }

}