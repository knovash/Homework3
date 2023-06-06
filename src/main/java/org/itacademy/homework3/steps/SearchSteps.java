package org.itacademy.homework3.steps;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.pages.SearchPage;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

@Log4j2
public class SearchSteps {

    private SearchPage searchPage; // создаем поле пэйджи

    // конструктор создания класса степов
    public SearchSteps(WebDriver driver) {
        searchPage = new SearchPage(driver);
    }

    // методы из пэйджи

    public void clickSearchButton() {
        log.info("CLICK SEARCH BUTTON");
        WaitUtils.waitForVisibility(searchPage.getSearchButton());
        searchPage.getSearchButton().click();
    }

    public void enterSearchFieldText(String text) {
        log.info("SEARCH FIELD");
        WaitUtils.waitForVisibility(searchPage.getSearchField());
        log.info("SEARCH FIELD DISPLAYED: " + searchPage.getSearchField().isDisplayed());
        searchPage.getSearchField().sendKeys(text);
    }

    public void clickSearchStartButton() {
        log.info("CLICK SEARCH START");
        WaitUtils.waitForVisibility(searchPage.getSearchStartButton());
        searchPage.getSearchStartButton().click();
    }

    public Boolean getAssertResult(String item) {
        SoftAssert sa = new SoftAssert();
//        sa.assertFalse(resultItems.isEmpty(), "RESULT EMPTY");
        sa.assertFalse(searchPage.getResultItems().isEmpty(), "RESULT EMPTY");

        Boolean result = false;
        try {
//            resultItems.stream()
            searchPage.getResultItems().stream()

                    .map(w -> w.getText().toLowerCase())
                    .peek(t -> sa.assertTrue(t.contains(item), "ЭТО НЕ " + item + " " + t))
                    .forEach(x -> log.info(x));
            sa.assertAll();
            result = true;
        } catch (AssertionError error) {
            result = false;
            log.info("ERRORR ASSERT");
        }
        return result;
    }
}
