package org.itacademy.homework3.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.driver.DriverManager;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseElement {

    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(BaseElement.class);

    public BaseElement(WebDriver driver, SearchContext searchContext) {
        PageFactory.initElements(DriverManager.getDriver(), this);
        this.driver = driver;
    }


}
