package Dungeons.System;

import Dungeons.Items.Item;

public class Inventory implements InventoryManagement{
    private Item[] inventory;
    private int itemCount;
    private int[] usableSlots;
    private int usableSlotsCount = 0;

    public Inventory(int capacity){
        inventory = new Item[capacity];
        usableSlots = new int[inventory.length];
        itemCount = 0;
    }

    public void addItem(Item item){
        if (usableSlotsCount>0){
            inventory[usableSlots[0]] = item;
            for (int i = 0; i < usableSlotsCount-1; i++) {
                usableSlots[i] = usableSlots[i+1];
            }
            usableSlotsCount--;
        }else if (itemCount < inventory.length) {
            inventory[itemCount] = item;
            itemCount++;
        } else {
            System.out.println("Inventory is full!");
        }
    }

    public void removeItem(int index){
        if (index > 0 && index <= inventory.length && inventory[index-1] != null) {
            inventory[index-1] = null;
            usableSlots[usableSlotsCount] = index-1;
            itemCount--;
            usableSlotsCount++;
        }else{
            System.out.println("Your inventory index starts a 1. Accessing empty fields is impossible.");
        }
    }

    public void showInventory() {
        System.out.println("Player Inventory:");
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                if (i <10) {
                    String entry = "[0" + (i + 1) + "] " + inventory[i].getName() + " (" + inventory[i].getRarity() + ")";
                    System.out.printf("%-30s", entry); // space to 30 characters
                }else{
                    String entry = "[" + (i + 1) + "] " + inventory[i].getName() + " (" + inventory[i].getRarity() + ")";
                    System.out.printf("%-30s", entry); // space to 30 characters
                }
            } else {
                System.out.printf("%-30s", "[00] Empty");
            }

            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("Total items: "+itemCount);
    }

    public Item getItem(int index){
        return inventory[index-1];
    }

    public int getItemCount(){
        return itemCount;
    }

}
