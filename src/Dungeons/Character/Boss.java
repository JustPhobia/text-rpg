package Dungeons.Character;

import Dungeons.Items.Item;

public abstract class Boss extends CharacterModel {
    public  Boss(String name, float maxHealth, int level,  int experience) {
        super(name,maxHealth, maxHealth,level,experience, 1,0);
    }
    public boolean isAlive() {
        return (getHealth()>0);
    }
    protected void level(int level) {
    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void removeItem(int index) {

    }

    @Override
    public void showInventory() {

    }

    public abstract void addItem();

    public void fightLogic(CharacterModel player) {

    }
}
