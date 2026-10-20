package Dungeons.Character;

import Dungeons.Items.*;
import Dungeons.System.Inventory;

public class LucyBoss extends Boss {
    private static final float maxHealth = 30;
    private static final String name = "Lucy";
    private static final int level = 20;
    private static final int experience = 20;
    private final int capacity = 3;
    private Inventory inventory = new Inventory(capacity);
    public LucyBoss() {
        super(name, maxHealth, level, experience);
        addItem();
    }

    @Override
    public void addItem() {
        Item sword = new IronSword();
        Item healthPotion = new HealthPotion();
        inventory.addItem(sword);
        inventory.addItem(healthPotion);
        inventory.addItem(healthPotion);
    }

    @Override
    public void removeItem(int index) {
        super.removeItem(index);
    }

    public Item getItem(int index) {
        return inventory.getItem(index);
    }
    @Override
    public void fightLogic(CharacterModel player) {
        if (getHealth() < 8) {
            for (int i = 1; i <= capacity; i++) {
                if (inventory.getItem(i) instanceof HealingItems) {
                    inventory.getItem(i).use(this);
                    inventory.removeItem(i);
                    return;
                }
            }
        }
        for (int i = 1; i <= capacity; i++) {
            if (inventory.getItem(i) instanceof Weapon) {
                inventory.getItem(i).use(this, player);
                return;
            }
        }
    }
}
