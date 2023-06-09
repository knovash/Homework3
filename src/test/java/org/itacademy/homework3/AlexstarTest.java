package org.itacademy.homework3;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.pages.RuleElement;
import org.itacademy.homework3.steps.AlexstarSteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Log4j2
public class AlexstarTest extends BaseTest {

    private AlexstarSteps alexstarSteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageOnliner());
        driver.get(Config.getPageAlexstar());
        alexstarSteps = new AlexstarSteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(testName = "CheckAlexstar",
//            dataProvider = "items",
            description = "Verifys alexstar addressses")
    public void verifyAlexstarTest() {
        log.info("TEST ALEXSTAR" + driver);
        alexstarSteps.clickButttonToSettings();
        alexstarSteps.clickButttonEnterYandex();
        alexstarSteps.enterLogin("novashki");
        alexstarSteps.clickButttonSignIn();
        alexstarSteps.enterPassword("Darthvader1984");
        alexstarSteps.clickButttonSignIn();
//        alexstarSteps.clickButtonRuleRollDown();
        RuleElement ruleElement = alexstarSteps.getElementRule();
        log.info("ELEMENT " + ruleElement );
        ruleElement.getFieldActionFrase();

//        log.info("CLASS: " + alexstarSteps.getElementRule().getFieldActionFrase().getAttribute("class") );
//
//        log.info("TETXT: " + alexstarSteps.getElementRule().getFieldActionFrase().getText() );

//        log.info("RULE: \n" + rule);
//        Assert.assertEquals(alexstarSteps.getValueFieldSearch(), item.getName(), "VALUE NOT EQUAL " + item.getName());
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }

}