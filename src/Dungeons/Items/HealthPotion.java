package Dungeons.Items;

public class HealthPotion extends HealingItems{
    private static final String name =  "Health Potion";
    private static final int rarity = 1;
    private static final float healthAmount = 10;
    public HealthPotion() {
        super(name, rarity,  healthAmount);
    }
}
