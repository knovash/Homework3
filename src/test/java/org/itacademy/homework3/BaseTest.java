package org.itacademy.homework3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeTest
    public void beforetest() {
        LOGGER.info("BEFORE TEST do nothing");
    }

    @BeforeClass
    public void beforeclass() {
        LOGGER.info("BEFORE CLASS get driver");
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void aftermethod() {
        LOGGER.info("AFTER METHOD do nothing");
    }

    @AfterClass
    public void afterclass() {
        LOGGER.info("AFTER CLASS do nothing");
    }

    @AfterTest
    public void aftertest() {
        LOGGER.info("AFTER TEST quit driver");
        DriverManager.quitDriver();
    }
}
