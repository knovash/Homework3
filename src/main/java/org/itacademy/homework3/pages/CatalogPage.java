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

    @FindBy(xpath = "//input[@class='search__input']")
    private WebElement fieldSearch;

    @FindBy(xpath = "//a[@class='product__description']")
    private List<WebElement> productDescription;

//    result__item result__item_product
//    @FindBy(xpath = "//*[@class='search__result search__result_active']//div[@class='result__wrapper']")
    @FindBy(xpath = "//*[@class='result__item result__item_product'][1]")
    private WebElement resultActive;

    @FindBy(xpath = ".//*[contains(text(), 'в новостях')]")
    private WebElement buttonInNews;

    @FindBy(xpath = "//iframe[@class='modal-iframe']")
    private WebElement iframe;

    @FindBy(xpath = "//span[@class='i-checkbox__faux']")
    private WebElement checkbox;

    @FindBy(xpath = "//span[@class='i-checkbox__faux']")
    private List<WebElement> checkboxs;

    @FindBy(xpath = "//div[@class='compare-button compare-button_visible']")
    private WebElement buttonCompare;




    public WebElement getButtonCatalog() {
        return buttonCatalog;
    }

    public WebElement getFieldFastSearch() {
        return fieldFastSearch;
    }

    public WebElement getFieldSearch() {
        return fieldSearch;
    }

    public List<WebElement> getProductDescription() {
        return productDescription;
    }

    public WebElement getResultActive() {
        return resultActive;
    }

    public WebElement getButtonInNews() {
        return buttonInNews;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public List<WebElement> getCheckboxs() {
        return checkboxs;
    }

    public WebElement getButtonCompare() {
        return buttonCompare;
    }
}