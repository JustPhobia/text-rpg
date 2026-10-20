package Dungeons.Character;

public interface PvP {
    void takeDamage(CharacterModel opponent, float damage);
    void dealDamage(CharacterModel opponent, float damage);
    void heal(float heal);
    int getLevel();

}
