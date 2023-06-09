package org.itacademy.homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Log4j2
public class RuleElement extends BaseElement {

    private WebDriver driver;

    public RuleElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = ".//label[contains(text(), 'Активационная фраза')]")
    private WebElement fieldActionFrase;

    //label[contains(text(), 'Активационная фраза')]/following-sibling::div[1]/input
    @FindBy(xpath = "//label[contains(text(), 'Активационная фраза')]/following-sibling::div[1]/input")
    private WebElement actionFrase;

    public WebElement getFieldActionFrase() {
        log.info("FIELD ACTION FRASE");
        log.info(fieldActionFrase.getText() );
        return fieldActionFrase;
    }
}