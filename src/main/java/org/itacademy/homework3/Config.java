package org.itacademy.homework3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class Config {

    private static String chromeDriver;
    private static String testPage;

    public static void getProperties() {
        Properties properties = new Properties();
        URL resource = Main.class.getClassLoader().getResource("config.properties");
        File file = new File(Objects.requireNonNull(resource).getFile());
        try {
            FileInputStream in = new FileInputStream(file);
            properties.load(in);
            in.close();
            chromeDriver = properties.getProperty("chromedriver");
            testPage = properties.getProperty("testpage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getChromeDriver() {
        return chromeDriver;
    }

    public static String getTestPage() {
        return testPage;
    }
}
