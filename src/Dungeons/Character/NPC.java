package Dungeons.Character;

import Dungeons.GameEngine.GameRun;

public abstract class NPC extends CharacterModel {
    private int npcType;

    public NPC(String name,int level, int npcType){
        super(name, 10000000, 10000000,level, 0,2, npcType);
    }

    public abstract void interact(CharacterModel player, GameRun game);
}
