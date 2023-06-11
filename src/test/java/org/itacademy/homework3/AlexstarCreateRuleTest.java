package org.itacademy.homework3;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.Rule;
import org.itacademy.homework3.steps.AlexstarSteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.RulesToJSON;
import org.itacademy.homework3.utils.WaitUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Log4j2
public class AlexstarCreateRuleTest extends BaseTest {

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
            description = "Verifys alexstar addressses", enabled = true)
    public void verifyAlexstarTest() {
        log.info("TEST ALEXSTAR" + driver);
        alexstarSteps.clickButttonToSettings();
        alexstarSteps.clickButttonEnterYandex();
        alexstarSteps.enterLogin("novashki");
        alexstarSteps.clickButttonSignIn();
        alexstarSteps.enterPassword("Darthvader1981");
        alexstarSteps.clickButttonSignIn();
        alexstarSteps.clickButttonAuth();
        alexstarSteps.clickButttonCreateRuleHttp();
        alexstarSteps.getFirstRule();
        alexstarSteps.enterFrase("frase");
        alexstarSteps.enterResponse("response");
        alexstarSteps.enterWebhook("webhook");
        alexstarSteps.selectType();
        alexstarSteps.selectToggleSSL();
        WaitUtils.waitSeconds(2);

    }

}