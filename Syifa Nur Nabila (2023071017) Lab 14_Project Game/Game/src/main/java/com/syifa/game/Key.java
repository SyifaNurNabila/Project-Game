package com.syifa.game;

public class Key extends Item {
    public Key(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        System.out.println("You used the " + getName() + " to unlock a mysterious door.");
    }
}
