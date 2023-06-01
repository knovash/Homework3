package org.itacademy.homework3.steps.steps.stepsSearch;

import org.itacademy.homework3.pages.SearchPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StepGetResults {
    public static List<WebElement> get(SearchPage searchPage) {
        List<WebElement> items = searchPage.getSearchResultList();
        return items;
    }
}
