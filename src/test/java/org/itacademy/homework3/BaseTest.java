package org.itacademy.homework3;

import org.itacademy.homework3.driver.DriverManager;
import org.itacademy.homework3.pages.DeliveryPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforetest() {
        System.out.println("BEFORE TEST get driver (in BaseTest)");
        driver = DriverManager.getDriver(); // создает драйвер браузера для всех выполняемых тестов
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
