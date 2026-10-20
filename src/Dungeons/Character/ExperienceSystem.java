package Dungeons.Character;

public interface ExperienceSystem {
    void addExperience(int experience);
    void LevelUp();
    void gainExperience(CharacterModel opponent);
    int getExperience();
    void maxHealthInc();
}
