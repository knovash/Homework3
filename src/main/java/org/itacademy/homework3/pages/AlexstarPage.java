package org.itacademy.homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//*[@class='fas fa-angle-down']")
    private WebElement buttonRuleRollDown;

    @FindBy(xpath = "//div[@class='col-12 p-3  bg-white']")
    private WebElement rule;

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

    public WebElement getButtonRuleRollDown() {
        return buttonRuleRollDown;
    }

    public WebElement getRule() {
        log.info("RULE " + rule.getAttribute("outerHTML"));
        return rule;
    }


}