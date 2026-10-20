package Dungeons.Character;

import Dungeons.Items.HealthPotion;
import Dungeons.Items.IronSword;
import Dungeons.Items.Item;

import java.util.Scanner;

public class CharacterTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player = new Player("Arin");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Player Menu ===");
            System.out.println("1. Show Inventory");
            System.out.println("2. Use Item");
            System.out.println("3. Add Item");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    player.showInventory();
                    break;

                case "2":
                    System.out.print("Enter slot number to use: ");
                    try {
                        int slot = Integer.parseInt(input.nextLine());
                        player.removeItem(slot);
                        System.out.println("You used the item in slot " + slot + "!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;

                case "3":
                    System.out.println("Which item would you like to add?");
                    System.out.println("a. Iron Sword");
                    System.out.println("b. Health Potion");
                    System.out.print("Choice: ");
                    String itemChoice = input.nextLine();

                    Item itemToAdd = null;
                    if (itemChoice.equalsIgnoreCase("a")) {
                        itemToAdd = new IronSword();
                    } else if (itemChoice.equalsIgnoreCase("b")) {
                        itemToAdd = new HealthPotion();
                    }

                    if (itemToAdd != null) {
                        player.addItem(itemToAdd);
                        System.out.println("Added " + itemToAdd.getName() + " to inventory!");
                    } else {
                        System.out.println("Invalid item choice.");
                    }
                    break;

                case "4":
                    exit = true;
                    System.out.println("Exiting game. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}