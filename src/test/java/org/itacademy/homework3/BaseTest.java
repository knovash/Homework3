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
        LOGGER.info("BEFORE TEST get driver (in BaseTest)");
        // зачем создавать перед тестом если всегда выполниться в бефо класс?
//        driver = DriverManager.getDriver(); // создает драйвер браузера для всех выполняемых тестов
    }

    @BeforeClass
    public void beforeclass() {
        LOGGER.info("BEFORE CLASS get driver (in BaseTest)");
        driver = DriverManager.getDriver(); // в бефо тест недостаточно. тут нужен для запуска следущего теста в сьюте
    }

    @AfterMethod // выполниться после каждого элемента дата провайдера
    public void aftermethod() {
        LOGGER.info("AFTER METHOD do nothing (in BaseTest)");
    }

    @AfterClass
    public void afterclass() {
        LOGGER.info("AFTER CLASS do nothing (in BaseTest)");
    }

    @AfterTest
    public void aftertest() {
        LOGGER.info("AFTER TEST quit driver (in BaseTest)");
        DriverManager.quitDriver();
    }

}
