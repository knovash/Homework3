package org.itacademy.homework3.utils;

import org.itacademy.homework3.models.Rule;
import org.itacademy.homework3.models.RulesList;

import java.util.List;

public class RulesToJSON {

    public static void toJson(List<Rule> list) {
        RulesList rulesList = new RulesList();
        rulesList.setRules(list);
        GenerateJSON.objectToFile(rulesList, "src/main/resources/data/rules.json");
    }
}