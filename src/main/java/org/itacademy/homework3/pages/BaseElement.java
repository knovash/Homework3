package org.itacademy.homework3.pages;

import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected WebElement root;

    public BaseElement(WebElement root){
        this.root = root;
    }
}
