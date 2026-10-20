package Dungeons.GameEngine;
import Dungeons.Character.CharacterModel;
import Dungeons.Character.Jaunte_NPC;
import Dungeons.Character.LucyBoss;
import Dungeons.Character.Player;

import Dungeons.Items.HealthPotion;
import Dungeons.Items.IronSword;
import Dungeons.System.CombatSystem;

import java.util.Scanner;

public class GameRun {

    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new GameRun().start();
    }

    private void start() {
        CharacterModel player = new Player(playerInitiate());
        Jaunte_NPC jaunte = new Jaunte_NPC();
        LucyBoss lucy  = new LucyBoss();
        player.addItem(new IronSword());
        player.addItem(new HealthPotion());
        jaunte.interact(player, this);
        System.out.println("\nYou enter the forest and confront " + lucy.getName() + "!");
        new CombatSystem().initiateFight(player, lucy, this);
        if (!lucy.isAlive()) {
            System.out.println("Victory!");
        } else if (!player.isAlive()) {
            System.out.println("Game over.");
        }
        shutdown();
    }

    private String playerInitiate() {
        System.out.println("Please enter your name: ");
        return sc.nextLine();
    }

    public String getInputString() {
        return sc.nextLine();
    }
    public char getInputChar() {
        boolean error = false;
        char first='0';
        String choice;
        do {
            if (error){
                System.out.println("Your input is... confusing, try again.");
            }
            choice = getInputString().trim();

            if (choice.isEmpty()) {
                continue;
            }
            first = Character.toLowerCase(choice.charAt(0));
            error = true;
        }while (first != 'y' && first != 'n');

        return first;
    }
    public int getInputInt() {
        while (true) {
            try {
                return Integer.parseInt(getInputString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private void shutdown() {
        sc.close(); // ONLY close when game fully exits
    }
}
