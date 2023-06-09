package org.itacademy.homework3.pages;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class RuleElement {

    private AlexstarPage alexstarPage; // создаем поле пэйджи

    // конструктор создания класса степов
    public RuleElement(WebDriver driver) {
        alexstarPage = new AlexstarPage(driver);
    }

    // методы из пэйджи



    public WebElement getElementRule() {
//        WaitUtils.waitForVisibility(alexstarPage.getRule());
//        log.info("DISPLAYED getButtonAlexstar: " + alexstarPage.getRule().isDisplayed());

        WebElement element = alexstarPage.getRule();

//        WaitUtils.waitForVisibility(driver, driver.findElement(By.xpath(path)));
//        WebElement sss = driver.findElement(By.xpath(path));

        return alexstarPage.getRule();


}}