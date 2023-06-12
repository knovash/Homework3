package org.itacademy.homework3;

import lombok.extern.log4j.Log4j2;
import org.itacademy.homework3.models.Rule;
import org.itacademy.homework3.pages.RuleElement;
import org.itacademy.homework3.steps.AlexstarSteps;
import org.itacademy.homework3.utils.Config;
import org.itacademy.homework3.utils.RulesToJSON;
import org.itacademy.homework3.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Log4j2
public class AlexstarTest extends BaseTest {

    private AlexstarSteps alexstarSteps;

    @BeforeMethod
    public void beforemethod() {
        log.info("BEFORE METHOD get page " + Config.getPageOnliner());
        driver.get(Config.getPageAlexstar());
        alexstarSteps = new AlexstarSteps(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(testName = "CheckAlexstar",
//            dataProvider = "items",
            description = "Verifys alexstar addressses", enabled = true)
    public void verifyAlexstarTest() {
        log.info("TEST ALEXSTAR" + driver);
        alexstarSteps.clickButttonToSettings(); // кнопка перейти к настройкам
        alexstarSteps.clickButttonEnterYandex(); // кнопка войти через яндекс
        alexstarSteps.enterLogin();
        alexstarSteps.clickButttonSignIn();
        alexstarSteps.enterPassword();
        alexstarSteps.clickButttonSignIn();
        List<Rule> list = alexstarSteps.getElementsRules(); // получить лист list объектов правил со страницы
        list.stream().forEach(rule -> { log.info(rule);}); // вывод в лог всех объектов правил
        RulesToJSON.toJson(list, "src/main/resources/data/rules.json"); // лист передаем в метод конвертации объектов в json в файл
        WaitUtils.waitSeconds(3); // подождать посмотреть на результат поиска
    }

}