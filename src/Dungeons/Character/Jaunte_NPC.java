package Dungeons.Character;

import Dungeons.GameEngine.GameRun;
import Dungeons.Items.Item;

public class Jaunte_NPC extends  NPC {
    private final String[] playerResponses = {
            "1. I'm here to mend my items.",
            "2. I'm looking to buy new gear.",
            "3. Just passing through the village.",
            "4. Do you have any news from around here?",
            "5. Goodbye."
    };
    private boolean quest = true;


    public Jaunte_NPC(){
        super("Jaunte", 1, 3);
    }


    @Override
    public void interact(CharacterModel player, GameRun game) {
        boolean interaction = true;
        if (errorCheck(player, game) == 'y') {
                while (interaction){
                switch(getPlayerResponses(game)) {
                    case 1:
                        getMending(player);
                        continue;
                    case 2:
                        getGear(player);
                        continue;
                    case 3:
                        playerLoitering(player);
                        continue ;
                    case 4:
                        initiateQuest(player);
                        continue;
                    case 5:
                        farewell(player);
                        interaction = false;
                        break;
                    default:
                        System.out.println("You: (silence)");
                        System.out.println(getName() + ": Hmm… not very talkative, are you?");
                }

            }
        }
    }

    public char errorCheck(CharacterModel player, GameRun game) {
        System.out.println("Would you like to interact with Jaunte? [Y/N]");
        return game.getInputChar();
    }

    public void farewell(CharacterModel player){
        System.out.println(player.getName() + ": Goodbye!");
        System.out.println(getName() + ": Farewell, traveler. May fortune smile upon you.");
    }

    public void getMending(CharacterModel player){
        System.out.println(player.getName() + ": I'm here to mend my items.");
        System.out.println(getName() + ": The blacksmith can help you with that. His forge is near the town square.");
    }

    public void getGear(CharacterModel player){
        System.out.println(player.getName() + ": I'm looking to buy new gear.");
        System.out.println(getName() + ": The merchant has fine wares. You’ll find him by the marketplace.");
    }
    @Override
    public void initiateQuest(CharacterModel player) {
        System.out.println(player.getName() + ": Do you have any news from around here?");
        if (quest) {
            System.out.println(getName() + ": Bandits have been spotted near the forest. Best be cautious if you head that way.");
        }else{
            System.out.println(getName() + ": I'm afraid not traveller. I shall keep \nmy ears open to any talk of other mischief however");
        }
    }

    public void playerLoitering(CharacterModel player){
        System.out.println(player.getName() + ": Just passing through the village.");
        System.out.println(getName() + ": Safe travels then! May the road be kind to you.");
    }

    public int getPlayerResponses(GameRun game) {

        System.out.println("\n==========================");
        for (String response : playerResponses) {
            System.out.println(response);
        }
        System.out.println("==========================");
        System.out.println("(Select your choice by selecting the number you wish to use)");
        int userChoice = game.getInputInt();
        System.out.println();
        return userChoice;
    }

    public void finQuest() {
        this.quest = false;
    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void removeItem(int index) {

    }

    @Override
    public void showInventory() {

    }
}
