package Dungeons.Items;

import Dungeons.Character.CharacterModel;

public class Item implements Usability {
    private String name;
    private final int rarity;
    private final String[] rarityLevels = {"Common", "Uncommon", "Rare","Epic", "Legendary"};

    public Item(String name, int rarity){
        this.name = name;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarityLevels[rarity];
    }

    @Override
    public void use(CharacterModel character) {

    }

    @Override
    public void use(CharacterModel character, CharacterModel opponent) {

    }
}
