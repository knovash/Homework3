package org.itacademy.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DonerKing { // класс Page Object для взаимодействия с элементами страницы

    private WebDriver driver; // поле класса

    // конструктор класса FirstPage. ему передаем параметр объект вебдрайвер
    public DonerKing(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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

    @FindBy(xpath="//div[@class='col-xxs-12 col-xs-6 col-sm-4 col-md-4 col-lg-4 menuItemWrapper']//div[@class='imageData']//div[@class='h4']")
    List<WebElement> resultItems;

    // методы класса пэйж обжект это действия с элементы страницы

    // нажать кнопку открыть поле поиска
    public void clickSearchButton() {
        System.out.println("CLICK");
        System.out.println("CLICK DRIVER " + driver);
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