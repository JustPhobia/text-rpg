package Dungeons.System;
import Dungeons.Items.Item;

public interface InventoryManagement {
        void addItem(Item item);
        void removeItem(int index);
        void showInventory();

}
