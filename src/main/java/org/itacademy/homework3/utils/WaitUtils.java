package org.itacademy.homework3.utils;

import org.itacademy.homework3.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForVisibility(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitSeconds(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {

        }
    }
}