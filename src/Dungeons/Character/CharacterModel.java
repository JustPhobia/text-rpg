package Dungeons.Character;

import Dungeons.System.InventoryManagement;

public abstract class CharacterModel implements PvP, ExperienceSystem, FunctionNPC, InventoryManagement {
    private final String name;
    private float health;
    private float maxHealth;
    private int level;
    private int experience;
    private int type;
    private final String[] choiceTypes = {"Player", "Boss", "NPC"};
    private int npcType;
    private final String[] typeNPC = {"None","Villager", "Merchant", "Questgiver"};

    public CharacterModel(String name, float health, float maxHealth, int level, int experience, int  type, int npcType) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.level = level;
        this.type = type;
        this.npcType = npcType;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return choiceTypes[type];
    }

    public float getHealth() {
        return health;
    }



    @Override
    public void takeDamage(CharacterModel opponent, float damage) {
        if (health -damage <0){
            this.health =0;
        }else{
            this.health -= damage;
        }
    }

    @Override
    public void dealDamage(CharacterModel opponent, float damage) {
        opponent.takeDamage(this, damage);
    }


    public boolean isAlive(){
        return health > 0;
    }

    @Override
    public void heal(float heal) {
        if (health + heal >maxHealth) {
            health = maxHealth;
        }else{
            health += heal;
        }
    }

    public int getLevel() {
        return this.level;
    }

    public void incLevel() {
        this.level++;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

    @Override
    public void maxHealthInc() {
        if (level%10 == 0){
            maxHealth +=3;
        }else if (level%5 == 0) {
            maxHealth += 2;
            System.out.println("Max Health Increased! New Max Health: " + maxHealth);
        }
    }

    public void LevelUp() {
        while (experience >= 100) {
            incLevel(); experience -= 100;
            System.out.println("Level Up! Level: " + level);
            maxHealthInc();
        }
    }

    @Override
    public int getExperience() {
        return experience;
    }

    public void gainExperience(CharacterModel opponent) {
        addExperience(opponent.getExperience());
    }

    @Override
    public String toString() {
        return "Name: " + name + " " + "Health: " + health + " " + "Type: " + choiceTypes[type];
    }
    public void interact(CharacterModel player) {
    }

    public void initiateQuest(CharacterModel player) {

    }

    @Override
    public void questComplete() {
    }

    public String getNPCType(){
        return  typeNPC[npcType];
    }
}
