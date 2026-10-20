package Dungeons.Items;
import Dungeons.Character.*;


public class Weapon extends  Item {
    private float damage;
    private int durability;

    public Weapon(String name, int rarity, int durability, float damage) {
        super(name, rarity);
        this.damage = damage;
        this.durability = durability;
    }

    void setDamage(float damage) {
        this.damage = damage;
    }

    public void use(CharacterModel character, CharacterModel opponent) {
        attack(character, opponent);
    }
    private void attack(CharacterModel character, CharacterModel opponent) {
        if ((character instanceof Player || character instanceof Boss) && (opponent instanceof Player || opponent instanceof Boss)) {
            if (durability > 0) {
                character.dealDamage(opponent, damage);
                System.out.println(opponent.getName() + " took " + damage + " damage!");
                durability -= 1;
            }else{
                System.out.println("Your " + getName() + " is damaged! Find a Weapons Smith to mend it");
                setName("(Damaged) "+ getName());
                character.dealDamage(opponent,  damage/2);
            }
        }else{
            System.out.println("Incorrect target");
        }
    }
}
