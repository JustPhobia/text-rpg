package Dungeons.System;

import Dungeons.Character.Boss;
import Dungeons.Character.CharacterModel;
import Dungeons.Character.Player;
import Dungeons.GameEngine.GameRun;
import Dungeons.Items.HealingItems;
import Dungeons.Items.Item;
import Dungeons.Items.Weapon;

import java.util.Scanner;

public class CombatSystem {
    private boolean playOn = true;

    public CombatSystem() {
    }

    public void initiateFight(CharacterModel player, CharacterModel boss, GameRun game) {
        playOn = true;
        while (playOn) {
            playerTurn(player, boss, game);

            if (boss instanceof Boss) {
                if (boss.isAlive()) {
                    ((Boss) boss).fightLogic(player);
                }
            }
            if (player.isAlive() && boss.isAlive()) {
                System.out.println("Would you like to play on? [Y/N]");
                if (game.getInputChar() == 'n') {
                    System.out.println(player + " has run away from the fight!");
                    playOn = false;
                }
            } else {
                if (!boss.isAlive()) {
                    System.out.println(boss.getName() + " has been defeated! Run, proud in your glory!");
                } else if (!player.isAlive()) {
                    System.out.println(player.getName() + " has been defeated!\nYou will respawn shorty ");
                }
                playOn = false;
            }
        }
    }

    private void playerTurn(CharacterModel player, CharacterModel boss, GameRun game) {
        boolean valid = false;
        while (!valid) {
            if (player instanceof Player) {
                player.showInventory();
                System.out.println("Select an item to use using its index!");

                valid = playerUseItem(player, boss, game);
            } else {
                System.out.println("Invalid player selected");
            }
        }
    }

    private boolean playerUseItem(CharacterModel player, CharacterModel boss, GameRun game) {
        int itemChoiceIndex = game.getInputInt();

        if (itemChoiceIndex < 1 || itemChoiceIndex > ((Player) player).getItemCount() || ((Player) player).getItem(itemChoiceIndex) == null) {
            System.out.println("Please select a valid item!");
            return false;
        } else {
            Item selectedItem = ((Player) player).getItem(itemChoiceIndex);
            if (selectedItem instanceof HealingItems) {
                selectedItem.use(player);
                return true;
            } else if (selectedItem instanceof Weapon) {
                selectedItem.use(player, boss);
                System.out.println(boss.getName() + " HP: " + boss.getHealth());
                return true;
            } else {
                return false;
            }
        }

    }
}
