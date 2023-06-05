package org.itacademy.homework3.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchPage extends BasePage {

    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='main-header__search-block']//*[name()='svg']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='search-header__input']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='search-header__btn']")
    private WebElement searchStartButton;

    @FindBy(xpath = "//div[@class='row gallery inner-gallery']")
    private WebElement searchResults;

    @FindBy(xpath = "//div[@class='col-xxs-12 col-xs-6 col-sm-4 col-md-4 col-lg-4 menuItemWrapper']//div[@class='imageData']//div[@class='h4']")
    List<WebElement> resultItems;

    public void clickSearchButton() {
        LOGGER.info("CLICK SEARCH BUTTON");
        WaitUtils.waitForVisibility(searchButton);
        searchButton.click();
    }

    public void enterSearchFieldText(String text) {
        LOGGER.info("SEARCH FIELD DISPLAYED: " + searchField.isDisplayed());
        searchField.sendKeys(text);
    }

    public void clickSearchStartButton() {
        LOGGER.info("CLICK SEARCH START");
        searchStartButton.click();
    }

    public Boolean getAssertResult(String item) {
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(resultItems.isEmpty(), "RESULT EMPTY");
        Boolean result = false;
        try {
            resultItems.stream()
                    .map(w -> w.getText().toLowerCase())
                    .peek(t -> sa.assertTrue(t.contains(item), "ЭТО НЕ " + item + " " + t))
                    .forEach(x -> LOGGER.info(x));
            sa.assertAll();
            result = true;
        } catch (AssertionError error) {
            result = false;
            LOGGER.info("ERRORR ASSERT");
        }
        return result;
    }
}