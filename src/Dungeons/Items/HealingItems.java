package Dungeons.Items;

import Dungeons.Character.CharacterModel;

public class HealingItems extends Item {
    float healAmount;
    public HealingItems(String name, int rarity, float healAmount) {
        super(name, rarity);
        this.healAmount = healAmount;
    }
    @Override
    public void use(CharacterModel character) {
        heal(character);
    }
    private void heal(CharacterModel character) {
        System.out.println(character.getName() + " healed for " + this.healAmount + "HP\n"+character.getName() +" new HP: " +character.getHealth());
        character.heal(healAmount);
    }
}
