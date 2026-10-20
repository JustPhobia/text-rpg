package Dungeons.Items;

import Dungeons.Character.CharacterModel;

public interface Usability {
    void use(CharacterModel character);
    public void use(CharacterModel character, CharacterModel opponent);
}
