package com.syifa.game;

import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        createWorld();
    }

    private void createWorld() {
        // Create rooms
        Room entrance = new Room("You are at the entrance of a forgotten temple.");
        Room hall = new Room("You are in a long hallway with ancient carvings.");
        Room puzzleRoom = new Room("This room has strange symbols and a locked door.");
        Room treasureRoom = new Room("You see a glowing artifact on a pedestal.");

        // Connect rooms
        entrance.setExit("north", hall);
        hall.setExit("south", entrance);
        hall.setExit("east", puzzleRoom);
        puzzleRoom.setExit("west", hall);
        puzzleRoom.setExit("north", treasureRoom);
        treasureRoom.setExit("south", puzzleRoom);

        // Add items
        Item key = new Key("Key", "It looks like it opens a hidden mechanism.");
        puzzleRoom.setItem(key);

        Item artifact = new Item("Artifact", "An ancient glowing artifact.");
        treasureRoom.setItem(artifact);

        // Create player
        player = new Player("Explorer", entrance);
    }

    public void start() {
        System.out.println("Welcome to the Mystery of the Forgotten Temple!");
        boolean playing = true;

        while (playing) {
            System.out.println();
            System.out.println(player.getCurrentRoom().getDescription());
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split(" ", 2);
            String command = parts[0];
            String argument = (parts.length > 1) ? parts[1] : "";

            switch (command.toLowerCase()) {
                case "go":
                    player.move(argument);
                    break;
                case "look":
                    System.out.println(player.getCurrentRoom().describe());
                    break;
                case "take":
                    player.takeItem(argument);
                    break;
                case "use":
                    player.useItem(argument);
                    break;
                case "inventory":
                    player.showInventory();
                    break;
                case "help":
                    CommandHelper.printHelp();
                    break;
                case "quit":
                    playing = false;
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    System.out.println("Unknown command. Try 'go', 'look', 'take', 'use', 'inventory', 'help', or 'quit'.");
                    break;
            }

            // Win condition
            if (player.getCurrentRoom().getDescription().toLowerCase().contains("entrance")
                    && player.hasItem("Artifact")) {
                System.out.println("You escaped the temple with the artifact. You win!");
                playing = false;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
