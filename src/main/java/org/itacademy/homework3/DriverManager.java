package org.itacademy.homework3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {

            Config.getProperties();
            System.setProperty("webdriver.chrome.driver", Config.getChromeDriver());
            driver = new ChromeDriver();
            System.out.println("MANAGER DRIVER " + driver);
//            DonerKing donerKing = new DonerKing(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//            driver.get(Config.getTestPage());
        }
        return driver;
    }

    public static void quitDriver() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}