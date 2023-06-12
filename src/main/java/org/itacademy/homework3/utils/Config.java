package org.itacademy.homework3.utils;

import org.itacademy.homework3.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class Config {

    private static String chromeDriver;
    private static String pageSearch;
    private static String pageDelivery;
    private static String pageOnliner;
    private static String pageAlexstar;
    private static String yandexLogin;
    private static String yandexPassword;

    public static void getProperties() {
        Properties properties = new Properties();
        URL resource = Main.class.getClassLoader().getResource("config.properties");
        File file = new File(Objects.requireNonNull(resource).getFile());
        try {
            FileInputStream in = new FileInputStream(file);
            properties.load(in);
            in.close();
            chromeDriver = properties.getProperty("chromedriver");
            pageSearch = properties.getProperty("page-main-search");
            pageDelivery = properties.getProperty("page-delivery");
            pageOnliner = properties.getProperty("page-onliner");
            pageAlexstar = properties.getProperty("page-alexstar");
            yandexLogin = properties.getProperty("yandex-login");
            yandexPassword = properties.getProperty("yandex-password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getChromeDriver() {
        return chromeDriver;
    }

    public static String getPageSearch() {
        return pageSearch;
    }

    public static String getPageDelivery() {
        return pageDelivery;
    }

    public static String getPageOnliner() {
        return pageOnliner;
    }

    public static String getPageAlexstar() {
        return pageAlexstar;
    }

    public static String getYandexLogin() {
        return yandexLogin;
    }

    public static String getYandexPassword() {
        return yandexPassword;
    }
}
