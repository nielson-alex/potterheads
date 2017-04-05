/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import static byui.cit260.potterheads.model.InventoryItem.InventoryItemType.taser;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.Spell;
import java.util.ArrayList;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class DuelView extends View {

    public DuelView() {
        super("\n'Scared, Potter?' Malfoy taunts you, unaware that you're not\n"
                + "Harry Potter.\n"
                + "Do you want to use an item or a spell against Malfoy?\n\n"
                + "I - Item\n"
                + "S - Spell\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "I":
                this.useItem();
                break;
            case "S":
                this.useSpell();
                break;
            case "Q":
                return true;
            default:
                this.console.println("\nEnter a valid selection");
                break;
        }

        return false;
    }

    private boolean useItem() {
        this.console.println("\nWhat item do you want to use?");

        Scanner keyboard = new Scanner(System.in);

        StringBuilder line;

        Game game = Potterheads.getCurrentGame();
        Player player = potterheads.Potterheads.getPlayer();
//        InventoryItem[] inventory = game.getInventory();

        ArrayList<InventoryItem> inventory = game.getTradeableInventory();

        this.console.println("\n          Items");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "DESCRIPTION");
        this.console.println(line.toString());

        //for each inventory item
        for (InventoryItem tradeableInventory : inventory) {
            line = new StringBuilder("                                                  ");
            line.insert(0, tradeableInventory.getName());
            line.insert(25, tradeableInventory.getDescription());

            //Display the line
            this.console.println(line.toString());
        }

        String choice = keyboard.nextLine();
        choice = choice.toUpperCase();

        switch (choice) {
            case "TASER":
                if (!(player.getInventoryItems().contains(new InventoryItem(taser)))) {
                    this.console.println("\nYou don't even have this.");
                } else {
                    this.console.println("\n'Avada Kedavra!' you scream as you shoot Malfoy.\n"
                            + "Holy cow, you're a psycho.\n"
                            + "You go to Azkaban for the rest of your life.\n\n"
                            + "Game over.");

                    CheatEndingView cheatEndingView = new CheatEndingView();
                    cheatEndingView.displayCheatEndingView();
                }
                break;
            default:
                this.console.println("\nEnter a valid selection.");
                break;
        }
        return false;
    }

    private boolean useSpell() {
        Scanner keyboard = new Scanner(System.in);
        StringBuilder line;
        Player player = potterheads.Potterheads.getPlayer();

        this.console.println("\nWhat spell do you want to use?");

        Game game = Potterheads.getCurrentGame();
        ArrayList<Spell> inventory = game.getSpellInventory();

        this.console.println("\n          List of Spells Learned");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "EFFECT");
        this.console.println(line.toString());

        //for each inventory item
        for (Spell spellInventory : inventory) {
            line = new StringBuilder("                                                  ");
            line.insert(0, spellInventory.getName());
            line.insert(25, spellInventory.getEffect());

            //Display the line
            this.console.println(line.toString());
        }

        String choice = keyboard.nextLine();
        choice = choice.toUpperCase();

        switch (choice) {
            case "AVADA KEDAVRA":
                boolean hasAvadaKedavra = false;

                for (Spell spell : player.getSpells()) {
                    if (spell.getType() == Spell.SpellType.avadaKedavra) {
                        hasAvadaKedavra = true;
                    }
                }

                if (!(hasAvadaKedavra == false)) {
                    this.console.println("\nYou straight up murdered Malfoy. You go to\n"
                            + "Azkaban for the rest of your life.");
                    BadEndingView badEndingView = new BadEndingView();
                    badEndingView.displayBadEndingView();
                } else {
                    this.console.println("\nYou haven't learned this one yet.");
                }
                break;
            default:
                this.console.println("\nEnter a valid selection.");
                break;
        }
        return false;
    }
}
