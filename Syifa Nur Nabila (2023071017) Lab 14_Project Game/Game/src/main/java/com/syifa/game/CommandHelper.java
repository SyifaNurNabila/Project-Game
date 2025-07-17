package com.syifa.game;

public class CommandHelper {
    public static void printHelp() {
        System.out.println("=== HELP MENU ===");
        System.out.println("Available commands:");
        System.out.println("- go [direction]   : Move to another room (north, south, etc.)");
        System.out.println("- look             : Look around the current room");
        System.out.println("- take [item]      : Pick up an item in the room");
        System.out.println("- use [item]       : Use an item from your inventory");
        System.out.println("- inventory        : Show your current inventory");
        System.out.println("- help             : Show this help menu");
        System.out.println("- quit             : Exit the game");
        System.out.println("==================");
    }
}
