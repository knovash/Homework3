package org.itacademy.homework3.steps;

import org.itacademy.homework3.pages.MainSearch;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StepGetResults {
    public static List<WebElement> get(MainSearch mainSearch) {
        List<WebElement> items = mainSearch.getSearchResultList();
        return items;
    }
}
