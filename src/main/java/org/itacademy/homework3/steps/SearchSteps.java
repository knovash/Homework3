package org.itacademy.homework3.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.pages.MenuSearchPage;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

@Log4j2
public class SearchSteps {

    private MenuSearchPage menuSearchPage;

    public SearchSteps(WebDriver driver) {
        menuSearchPage = new MenuSearchPage(driver);
    }

    @Step("Click search button for show search field")
    public void clickSearchButton() {
        log.info("Click search button for show search field");
        WaitUtils.waitForVisibility(menuSearchPage.getSearchButton());
        menuSearchPage.getSearchButton().click();
    }

    @Step("Enter text in search field")
    public void enterSearchFieldText(String text) {
        log.info("Enter text in search field");
        WaitUtils.waitForVisibility(menuSearchPage.getSearchField());
        menuSearchPage.getSearchField().sendKeys(text);
    }

    @Step("Click start search button")
    public void clickSearchStartButton() {
        log.info("Click start search button");
        WaitUtils.waitForVisibility(menuSearchPage.getSearchStartButton());
        menuSearchPage.getSearchStartButton().click();
    }

    @Step("Get result list of menu items")
    public SoftAssert getAssert(String menuItem) {
        log.info("Get result list of menu items");
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(menuSearchPage.getResultItems().isEmpty(), "RESULT LIST IS EMPTY");
        menuSearchPage.getResultItems().stream()
                .map(webElement -> webElement.getText().toLowerCase())
                .peek(text -> sa.assertTrue(text.contains(menuItem), "IT IS NOT A " + menuItem))
                .forEach(x -> log.info(x));
        sa.assertAll();
        return sa;
    }
}
