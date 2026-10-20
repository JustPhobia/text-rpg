package Dungeons.Character;

import Dungeons.Items.Item;
import Dungeons.System.Inventory;

public class Player extends CharacterModel{
    private final int defaultDamage =1;
    private final int capacity = 20;
    private Inventory inventory = new Inventory(capacity);

    public Player(String name) {
        super(name,20,20,0, 0, 0,0);
    }

    public boolean playerIsAlive(){
        return (getHealth()>0);
    }
    @Override
    public void heal(float heal) {
        super.heal(heal);
    }

    @Override
    public void addItem(Item item) {
        inventory.addItem(item);
    }

    @Override
    public void removeItem(int index) {
        inventory.removeItem(index);
    }

    @Override
    public void showInventory() {
        inventory.showInventory();
    }

    public Item getItem(int index){
        return inventory.getItem(index);
    }

    public int  getItemCount(){
        return inventory.getItemCount();
    }
}
