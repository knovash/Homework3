package org.itacademy.homework3.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage { // класс Page Object для взаимодействия с элементами страницы

    private WebDriver driver;


    private static final Logger LOGGER = LogManager.getLogger(SearchPage.class);

    // конструктор класса наследуется от бэйспэйж
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // поля класса пэйж обжект это элементы страницы

    // кнопка открыть поле поиска
    @FindBy(xpath = "//a[@class='main-header__search-block']//*[name()='svg']")
    private WebElement searchButton;

//    String path = "//a[@class='main-header__search-block']//*[name()='svg']";
//    private WebElement searchButton = driver.findElement(By.xpath(path));

    // поле поиска
    @FindBy(xpath = "//input[@class='search-header__input']")
    private WebElement searchField;

    // кнопка Искать
    @FindBy(xpath = "//button[@class='search-header__btn']")
    private WebElement searchStartButton;

    // результаты поиска
    @FindBy(xpath = "//div[@class='row gallery inner-gallery']")
    private WebElement searchResults;

    @FindBy(xpath = "//div[@class='col-xxs-12 col-xs-6 col-sm-4 col-md-4 col-lg-4 menuItemWrapper']//div[@class='imageData']//div[@class='h4']")
    List<WebElement> resultItems;


    // методы класса пэйж обжект это действия с элементы страницы

    // нажать кнопку открыть поле поиска
    public void clickSearchButton() {
        LOGGER.info("CLICK");
        LOGGER.info("CLICK DRIVER " + driver);
        WaitUtils.waitForVisibility(searchButton);
        searchButton.click();
    }

    // получить поле поиска
    public WebElement getSearchField() {
        return searchField;
    }

    // нажать кнопку Искать
    public void clickSearchStartButton() {
        searchStartButton.click();
    }

    public List<WebElement> getSearchResultList() {
        return resultItems;
    }
}