package org.itacademy.homework3.steps.steps.stepsSearch;

import org.itacademy.homework3.pages.SearchPage;

public class StepRunSearch {

    public static void runSearch(SearchPage searchPage, String menuItem) {
        searchPage.clickSearchButton();
        System.out.println("SEARCH FIELD DISPLAYED: " + searchPage.getSearchField().isDisplayed());
        searchPage.getSearchField().sendKeys(menuItem); // метод которые возвращает само поле поиска
        searchPage.clickSearchStartButton();
    }
}
