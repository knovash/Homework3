package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.pages.AlexstarPage;
import org.itacademy.homework3.pages.RuleElement;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AlexstarSteps {

    private AlexstarPage alexstarPage; // создаем поле пэйджи

    // конструктор создания класса степов
    public AlexstarSteps(WebDriver driver) {
        alexstarPage = new AlexstarPage(driver);
    }

    // методы из пэйджи

    public void clickButttonToSettings() {
        WaitUtils.waitForVisibility(alexstarPage.getButtonToSettings());
        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getButtonToSettings().isDisplayed());
        alexstarPage.getButtonToSettings().click();
    }

    public void clickButttonEnterYandex() {
        WaitUtils.waitForVisibility(alexstarPage.getButtonEnterYandex());
        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getButtonEnterYandex().isDisplayed());
        alexstarPage.getButtonEnterYandex().click();
    }

    public void enterLogin(String login) {
        WaitUtils.waitForVisibility(alexstarPage.getFieldLogin());
        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getFieldLogin().isDisplayed());
        alexstarPage.getFieldLogin().sendKeys(login);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForVisibility(alexstarPage.getFieldPassword());
        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getFieldPassword().isDisplayed());
        alexstarPage.getFieldPassword().sendKeys(password);
    }

    public void clickButttonSignIn() {
        WaitUtils.waitForVisibility(alexstarPage.getButtonSignIn());
        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getButtonSignIn().isDisplayed());
        alexstarPage.getButtonSignIn().click();
    }

    public void clickButtonRuleRollDown() {
        WaitUtils.waitForVisibility(alexstarPage.getButtonRuleRollDown());
        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getButtonRuleRollDown().isDisplayed());
        alexstarPage.getButtonRuleRollDown().click();
    }

    public RuleElement getElementRule() {
//        WaitUtils.waitForVisibility(alexstarPage.getRule());
//        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getRule().isDisplayed());
        return alexstarPage.getRule();
    }

//    public WebElement getFieldActonFrase() {
//        WaitUtils.waitForVisibility(alexstarPage.getActionFrase());
//        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getActionFrase().isDisplayed());
//        return alexstarPage.getActionFrase();
//    }


}
