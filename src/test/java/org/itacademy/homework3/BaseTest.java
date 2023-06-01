package org.itacademy.homework3;

import org.itacademy.homework3.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforetest() {
        System.out.println("BEFORE TEST get driver (in BaseTest)");
        // зачем создавать перед тестом если все
//        driver = DriverManager.getDriver(); // создает драйвер браузера для всех выполняемых тестов
    }

    @BeforeClass
    public void beforeclass() {
        System.out.println("BEFORE CLASS get driver (in BaseTest)");
        driver = DriverManager.getDriver(); // в бефо тест недостаточно. тут нужен для запуска следущего теста в сьюте
    }

    @AfterMethod // выполниться после каждого элемента дата провайдера
    public void aftermethod() {
        System.out.println("AFTER METHOD do nothing (in BaseTest)");
    }

    @AfterClass
    public void afterclass() {
        System.out.println("AFTER CLASS do nothing (in BaseTest)");
    }

    @AfterTest
    public void aftertest() {
        System.out.println("AFTER TEST quit driver (in BaseTest)");
//        DriverManager.quitDriver();
    }

}
