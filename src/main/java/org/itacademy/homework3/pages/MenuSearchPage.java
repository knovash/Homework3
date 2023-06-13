package org.itacademy.homework3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuSearchPage extends BasePage {

    public MenuSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='main-header__search-block']//*[name()='svg']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='search-header__input']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='search-header__btn']")
    private WebElement searchStartButton;

    @FindBy(xpath = "//div[@class='col-xxs-12 col-xs-6 col-sm-4 col-md-4 col-lg-4 menuItemWrapper']//div[@class='imageData']//div[@class='h4']")
    List<WebElement> resultItems;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchStartButton() {
        return searchStartButton;
    }

    public List<WebElement> getResultItems() {
        return resultItems;
    }
}