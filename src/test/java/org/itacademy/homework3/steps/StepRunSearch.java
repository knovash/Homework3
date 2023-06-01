package org.itacademy.homework3.steps;

import org.itacademy.homework3.pages.MainSearch;

public class StepRunSearch {

    public static void runSearch(MainSearch mainSearch, String menuItem) {
        mainSearch.clickSearchButton();
        System.out.println("SEARCH FIELD DISPLAYED: " + mainSearch.getSearchField().isDisplayed());
        mainSearch.getSearchField().sendKeys(menuItem); // метод которые возвращает само поле поиска
        mainSearch.clickSearchStartButton();
    }
}
