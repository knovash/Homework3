package org.itacademy.homework3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rule {
    private String actionFrase;
    private String response;
    private String webHook;

    @Override
    public String toString() {
        return "Rule{" +
                "actionFrase='" + actionFrase + '\'' +
                ", response='" + response + '\'' +
                ", webHook='" + webHook + '\'' +
                '}';
    }
}
