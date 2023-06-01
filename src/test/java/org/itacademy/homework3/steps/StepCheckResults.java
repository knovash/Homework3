package org.itacademy.homework3.steps;

import org.itacademy.homework3.pages.MainSearch;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class StepCheckResults {
    public static void check(MainSearch mainSearch, List<WebElement> items, String menuItem) {

        System.out.println("\nFOUND ITEMS CONTAINS: " + menuItem);
        System.out.println(items.isEmpty() + " " + items.size() + " " + items);
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(items.isEmpty(), "RESULT EMPTY");
        items.stream()
                .map(w -> w.getText().toLowerCase()) // из каждого найденного элемнта получаем текст
                // проверяем что текст элемента содержит искомый текст
                .peek(t -> sa.assertTrue(t.contains(menuItem), "ЭТО НЕ " + menuItem + " " + t))
                .forEach(System.out::println);
        sa.assertAll();

    }
}
