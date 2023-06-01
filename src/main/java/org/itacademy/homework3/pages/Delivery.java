package org.itacademy.homework3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Delivery { // класс Page Object для взаимодействия с элементами страницы

    private WebDriver driver; // поле класса

    // конструктор класса FirstPage. ему передаем параметр объект вебдрайвер
    public Delivery(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // поля класса пэйж обжект это элементы страницы

    // поле город
    @FindBy(xpath = "//*[@id='city']")
    private WebElement fieldCity;

    // поле улица
    @FindBy(xpath = "//*[@id='street']")
    private WebElement fieldStreet;

    // поле дом
    @FindBy(xpath = "//*[@id='building']")
    private WebElement fieldBuilding;

    // кнопка проверить
    @FindBy(xpath = "//button[@class='search-header__btn']")
    private WebElement buttonCheck;


    // методы класса пэйж обжект это действия с элементы страницы

    public WebElement getFieldCity() {
        return fieldCity;
    }

    public WebElement getFieldStreet() {
        return fieldStreet;
    }

    public WebElement getFieldBuilding() {
        return fieldBuilding;
    }

    public void clickButtonCheck() {
        buttonCheck.click();
    }

}