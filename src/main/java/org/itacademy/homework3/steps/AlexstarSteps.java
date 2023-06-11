package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.Rule;
import org.itacademy.homework3.pages.AlexstarPage;
import org.itacademy.homework3.pages.RuleElement;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        log.info("DISPLAYED getButtonToSettings: " + alexstarPage.getButtonToSettings().isDisplayed());
        alexstarPage.getButtonToSettings().click();
    }

    public void clickButttonEnterYandex() {
        WaitUtils.waitForVisibility(alexstarPage.getButtonEnterYandex());
        log.info("DISPLAYED getButtonEnterYandex: " + alexstarPage.getButtonEnterYandex().isDisplayed());
        alexstarPage.getButtonEnterYandex().click();
    }

    public void enterLogin(String login) {
        WaitUtils.waitForVisibility(alexstarPage.getFieldLogin());
        log.info("DISPLAYED getFieldLogin: " + alexstarPage.getFieldLogin().isDisplayed());
        alexstarPage.getFieldLogin().sendKeys(login);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForVisibility(alexstarPage.getFieldPassword());
        log.info("DISPLAYED getFieldPassword: " + alexstarPage.getFieldPassword().isDisplayed());
        alexstarPage.getFieldPassword().sendKeys(password);
    }

    public void clickButttonSignIn() {
        WaitUtils.waitForVisibility(alexstarPage.getButtonSignIn());
        log.info("DISPLAYED getButtonSignIn: " + alexstarPage.getButtonSignIn().isDisplayed());
        alexstarPage.getButtonSignIn().click();
    }

    public void clickButttonAuth() {
        try {


            if (alexstarPage.getButtonSignIn().isDisplayed() == true) {
                log.info("CLICK AUTH");
                alexstarPage.getButtonAuth().click();
            }
        }
        catch (NoSuchElementException e){log.info("NO AUTH");}
    }

    public void clickButtonRuleRollDown() {
        WaitUtils.waitForVisibility(alexstarPage.getButtonRuleRollDown());
        log.info("DISPLAYED getButtonRuleRollDown: " + alexstarPage.getButtonRuleRollDown().isDisplayed());
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

    public List<Rule> getElementsRules() {
        Rule ruleObject = new Rule();
        List<WebElement> elements = alexstarPage.getRules();
        List<Rule> ruleList =
             elements.stream().map(context -> {
             Rule object = new Rule();
             log.info("CONTEXT: " + context);
             WebElement element;
             element = context.findElement(By.xpath(".//label[contains(text(), 'Активационная фраза')]/following-sibling::div[1]/input"));
             log.info("ELEMENT get value: " + element.getAttribute("value"));
             object.setActionFrase(element.getAttribute("value"));
             element = context.findElement(By.xpath(".//label[contains(text(), 'Ответ Кузи')]/following-sibling::div[1]/input"));
             log.info("ELEMENT get value: " + element.getAttribute("value"));
             object.setResponse(element.getAttribute("value"));
             element = context.findElement(By.xpath(".//label[contains(text(), 'URL управления устройством, ')]/following-sibling::input"));
             log.info("ELEMENT get value: " + element.getAttribute("value"));
             object.setWebHook(element.getAttribute("value"));
             return object;
                        })
             .collect(Collectors.toList());
        return ruleList;
    }

    public void clickButttonCreateRuleHttp() {
        WaitUtils.waitForVisibility(alexstarPage.getButtonCreateRuleHttp());
        log.info("DISPLAYED getButtonCreateRuleHttp: " + alexstarPage.getButtonCreateRuleHttp().isDisplayed());
        alexstarPage.getButtonCreateRuleHttp().click();
    }

    public void getFirstRule() {
        WaitUtils.waitForVisibility(alexstarPage.getFirstRule());
        log.info("DISPLAYED getButtonCreateRuleHttp: " + alexstarPage.getFirstRule().isDisplayed());
        log.info("HTML getButtonCreateRuleHttp: " + alexstarPage.getFirstRule().getAttribute("outerHTML"));
//        alexstarPage.getFirstRule().click();
    }

    public void enterFrase(String text) {
        WaitUtils.waitForVisibility(alexstarPage.getInputFrase());
        log.info("DISPLAYED getInputFrase: " + alexstarPage.getInputFrase().isDisplayed());
        log.info("HTML getInputFrase: " + alexstarPage.getInputFrase().getAttribute("outerHTML"));
        alexstarPage.getInputFrase().sendKeys(text);
        log.info("VALUE getInputFrase: " + alexstarPage.getInputFrase().getAttribute("value"));
    }

    public void enterResponse(String text) {
        WaitUtils.waitForVisibility(alexstarPage.getInputResponse());
        log.info("DISPLAYED getInputResponse: " + alexstarPage.getInputResponse().isDisplayed());
        log.info("HTML getInputResponse: " + alexstarPage.getInputResponse().getAttribute("outerHTML"));
        alexstarPage.getInputResponse().sendKeys(text);
        log.info("VALUE getInputResponse: " + alexstarPage.getInputResponse().getAttribute("value"));
    }

    public void enterWebhook(String text) {
        WaitUtils.waitForVisibility(alexstarPage.getInputWebHook());
        log.info("DISPLAYED getInputWebHook: " + alexstarPage.getInputWebHook().isDisplayed());
        log.info("HTML getInputWebHook: " + alexstarPage.getInputWebHook().getAttribute("outerHTML"));
        alexstarPage.getInputWebHook().sendKeys(text);
        log.info("VALUE getInputWebHook: " + alexstarPage.getInputWebHook().getAttribute("value"));
    }

    public void selectType() {
        WaitUtils.waitForVisibility(alexstarPage.getSelectType());
        log.info("DISPLAYED getSelectType: " + alexstarPage.getSelectType().isDisplayed());
        log.info("HTML getSelectType: " + alexstarPage.getSelectType().getAttribute("outerHTML"));
        alexstarPage.getSelectType().sendKeys("PATCH (application/json)");
        log.info("VALUE getSelectType: " + alexstarPage.getSelectType().getAttribute("value"));
    }

    public void selectToggleSSL() {
        WaitUtils.waitForVisibility(alexstarPage.getSelectToggleSSL());
        log.info("DISPLAYED getSelectToggleSSL: " + alexstarPage.getSelectToggleSSL().isDisplayed());
        log.info("HTML getSelectToggleSSL: " + alexstarPage.getSelectToggleSSL().getAttribute("outerHTML"));
        log.info("VALUE getSelectToggleSSL: " + alexstarPage.getSelectToggleSSL().getAttribute("value"));
        WaitUtils.waitSeconds(3);
        log.info("SELECTED: " + alexstarPage.getSelectToggleSSL().isSelected());
        WaitUtils.waitSeconds(3);
        alexstarPage.getSelectToggleSSL().click();
        WaitUtils.waitSeconds(3);
        log.info("SELECTED: " + alexstarPage.getSelectToggleSSL().isSelected());
        WaitUtils.waitSeconds(3);
    }


}
