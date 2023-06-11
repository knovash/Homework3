package org.itacademy.homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class AlexstarPage extends BasePage {

    private WebDriver driver;

    public AlexstarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='btn btn-success']")
    private WebElement buttonToSettings;

    @FindBy(xpath = "//a[contains(text(), 'Войти через Яндекс')]")
    private WebElement buttonEnterYandex;

    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement fieldLogin;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement buttonSignIn;


    @FindBy(xpath = "//button[@data-t='button:action']")
    private WebElement buttonAuth;

    @FindBy(xpath = "//*[@class='fas fa-angle-down']")
    private WebElement buttonRuleRollDown;

    @FindBy(xpath = "//div[@class='col-12 p-3  bg-white']")
    private WebElement rule;

    @FindBy(xpath = "//div[@class='col-12 p-3  bg-white']")
    private List<WebElement> rules;

    @FindBy(xpath = "//button[contains(text(), 'Добавить правило HTTP (GET)')]")
    private WebElement buttonCreateRuleHttp;


//    @FindBy(xpath = "//span[@class = 'badge badge-secondary' and text()='1']")
//    private WebElement firstRule;

    @FindBy(xpath = "//span[@class = 'badge badge-secondary' and text()='1']/../../..")
    private WebElement firstRule;

    @FindBy(xpath = ".//label[contains(text(), 'Активационная фраза')]/following-sibling::div[1]/input")
    private WebElement inputFrase;

    @FindBy(xpath = ".//label[contains(text(), 'Ответ Кузи')]/following-sibling::div[1]/input")
    private WebElement inputResponse;

    @FindBy(xpath = ".//label[contains(text(), 'URL управления устройством, ')]/following-sibling::input")
    private WebElement inputWebHook;

    @FindBy(xpath = ".//label[contains(text(), 'Тип запроса')]/following-sibling::select")
    private WebElement selectType;

    @FindBy(xpath = ".//label[contains(text(), 'Поиск значений в фразе')]/following-sibling::select")
    private WebElement selectValue;

    @FindBy(xpath = ".//label[contains(text(), 'Проверять SSL сертификат сервера')]/..//input")
//    @FindBy(xpath = ".//label[contains(text(), 'Проверять SSL сертификат сервера')]")
    private WebElement selectToggleSSL;

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getButtonToSettings() {
        return buttonToSettings;
    }

    public WebElement getButtonEnterYandex() {
        return buttonEnterYandex;
    }

    public WebElement getFieldLogin() {
        return fieldLogin;
    }

    public WebElement getFieldPassword() {
        return fieldPassword;
    }

    public WebElement getButtonSignIn() {
        return buttonSignIn;
    }

    public WebElement getButtonAuth() {
        return buttonAuth;
    }

    public WebElement getButtonRuleRollDown() {
        return buttonRuleRollDown;
    }

    public WebElement getRule() {
        return rule;
    }

    public List<WebElement> getRules() {
        return rules;
    }

    public WebElement getButtonCreateRuleHttp() {
        return buttonCreateRuleHttp;
    }

    public WebElement getFirstRule() {
        return firstRule;
    }

    public WebElement getInputFrase() {
        return inputFrase;
    }

    public WebElement getInputResponse() {
        return inputResponse;
    }

    public WebElement getInputWebHook() {
        return inputWebHook;
    }

    public WebElement getSelectType() {
        return selectType;
    }

    public WebElement getSelectValue() {
        return selectValue;
    }

    public WebElement getSelectToggleSSL() {
        return selectToggleSSL;
    }
}