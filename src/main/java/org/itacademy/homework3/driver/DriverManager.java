package org.itacademy.homework3.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.pages.DeliveryPage;
import org.itacademy.homework3.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    private static WebDriver driver;


    private static final Logger LOGGER = LogManager.getLogger(WebDriver.class);

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            Config.getProperties();
            System.setProperty("webdriver.chrome.driver", Config.getChromeDriver());
            driver = new ChromeDriver();
            LOGGER.info("MANAGER DRIVER " + driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void quitDriver() {
        LOGGER.info("MANAGER QUIT");
        try {
            driver.quit(); // закрыть браузер и драйвер
            driver = null; // занулить драйвер чтоб создался новый инстанс в синглтон
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeDriver() {
        LOGGER.info("MANAGER CLOSE");
        try {
            driver.close();
            driver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}