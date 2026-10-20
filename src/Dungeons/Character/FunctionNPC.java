package Dungeons.Character;

public interface FunctionNPC {
    void interact(CharacterModel player);
    void initiateQuest(CharacterModel player);
    void questComplete();
    String getNPCType();
}
