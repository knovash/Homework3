package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.Rule;
import org.itacademy.homework3.pages.AlexstarPage;
import org.itacademy.homework3.pages.RuleElement;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public Rule getElementRule() {
        SearchContext context = alexstarPage.getRule();
        Rule ruleObject = new Rule();
        log.info("CONTEXT: " + context);
        WebElement element;
        //        log.info("OUTER " + element.getAttribute("outerHTML"));
        element = context.findElement(By.xpath(".//label[contains(text(), 'Активационная фраза')]/following-sibling::div[1]/input"));
        log.info("ELEMENT get value: " + element.getAttribute("value"));
        ruleObject.setActionFrase(element.getAttribute("value"));
        element = context.findElement(By.xpath(".//label[contains(text(), 'Ответ Кузи')]/following-sibling::div[1]/input"));
        log.info("ELEMENT get value: " + element.getAttribute("value"));
        ruleObject.setResponse(element.getAttribute("value"));
        element = context.findElement(By.xpath(".//label[contains(text(), 'URL управления устройством, ')]/following-sibling::input"));
        log.info("ELEMENT get value: " + element.getAttribute("value"));
        ruleObject.setWebHook(element.getAttribute("value"));
        return ruleObject;
    }

    public void getElementsRules(){

//        List<SearchContext> contexts = alexstarPage.getRules();

    }

}
