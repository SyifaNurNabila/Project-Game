package com.syifa.game;

import java.util.ArrayList;

public class Player {
    private String name;
    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player(String name, Room startingRoom) {
        this.name = name;
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You move " + direction + ".");
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void takeItem(String itemName) {
        Item item = currentRoom.getItem();
        if (item != null && item.getName().equalsIgnoreCase(itemName)) {
            inventory.add(item);
            currentRoom.removeItem();
            System.out.println("You took the " + item.getName() + ".");
        } else {
            System.out.println("No such item here.");
        }
    }

    public void useItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.use();
                return;
            }
        }
        System.out.println("You don't have that item.");
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

    public boolean hasItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
