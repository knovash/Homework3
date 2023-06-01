package org.itacademy.homework3.pages;

import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryPage { // класс Page Object для взаимодействия с элементами страницы

    private WebDriver driver; // поле класса

    // конструктор класса FirstPage. ему передаем параметр объект вебдрайвер
    public DeliveryPage(WebDriver driver) {
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
    @FindBy(xpath = "//*[@id='search-query']")
    private WebElement buttonCheck;

    @FindBy(xpath = "//div[@id='delivery_status' and @class='success']")
    private WebElement statusSuccess;

    @FindBy(xpath = "//div[@id='delivery_status' and @class='fail']")
    private WebElement statusFail;




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
        WaitUtils.waitForVisibility(buttonCheck);
        buttonCheck.click();
    }

    public WebElement getStatusSuccess() {
        return statusSuccess;
    }

    public WebElement getStatusFail() {
        return statusFail;
    }

}