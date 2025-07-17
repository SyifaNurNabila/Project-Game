package com.syifa.game;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private Item item;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public String getDescription() {
        return description;
    }

    public String describe() {
        StringBuilder desc = new StringBuilder(description + "\nExits: ");
        for (String dir : exits.keySet()) {
            desc.append(dir).append(" ");
        }
        if (item != null) {
            desc.append("\nYou see a " + item.getName() + " here.");
        }
        return desc.toString();
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void removeItem() {
        this.item = null;
    }
}
