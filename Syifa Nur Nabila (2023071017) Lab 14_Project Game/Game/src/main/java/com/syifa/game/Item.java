package com.syifa.game;

public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void use() {
        System.out.println("You used the " + name + ". " + description);
    }
}
