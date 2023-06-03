package org.itacademy.homework3.models;

public class MenuItem {

    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public MenuItem() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
