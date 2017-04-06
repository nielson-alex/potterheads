/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.InventoryItem.InventoryItemType;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.Spell;
import java.util.ArrayList;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class DarkDungeonView extends View {

    public DarkDungeonView() {
        super("\nDo you want to use a spell to light the room?\n"
                + "(press 'Y' for yes, 'N' for no)");
    }

    @Override
    public boolean doAction(String value) {
        boolean done = false;
        StringBuilder line;
        value = value.toUpperCase();

        while (!done) {
            if ("Y".equals(value.toUpperCase())) {
                this.getNext();
            } else if ("N".equals(value.toUpperCase())) {
                return true;
            } else {
                this.console.println("\nEnter 'Y' or 'N'.");
                return false;
            }
            break;
//            Game game = Potterheads.getCurrentGame();
//    //        InventoryItem[] inventory = game.getInventory();
        }
        return true;
    }

    public boolean getNext() {
        Game game = Potterheads.getCurrentGame();
        ArrayList<Spell> learnedSpells = game.getSpellInventory();
        StringBuilder line;
        boolean done = false;

        while (!done) {

//        InventoryItem[] inventory = game.getInventory();
            this.console.println("\n    List of Spells Learned    ");
            line = new StringBuilder("                                                              ");
            line.insert(0, "NAME");
            line.insert(25, "EFFECT");
            this.console.println(line.toString());

            if ((learnedSpells.isEmpty())) {
                this.console.println("\nYou haven't learned any spells yet.\n"
                        + "(Press 'Q' to quit");
            } else {
                for (Spell spellInventory : learnedSpells) {
                    line = new StringBuilder("                                                  ");
                    line.insert(0, spellInventory.getName());
                    line.insert(25, spellInventory.getEffect());

                    //Display the line
                    this.console.println(line.toString());
                }
            }

            this.console.println("\nType the name of the spell you want to use.");

            boolean valid = false; //value to be returned
            String choice = null; // initialize to not valid

            try {
                while (!valid) { // loop while an invalid value is entered

                    choice = this.keyboard.readLine(); // get next line typed on keyboard
                    choice = choice.trim(); // trim off leading and trailing blanks

                    if (choice.length() < 1) { //value is blank
                        ErrorView.display(this.getClass().getName(), "you must enter a value.");
                        continue;
                    }
                    break; // end the loop
                }
            } catch (Exception e) {
                this.console.println("Error reading input: " + e.getMessage());
            }

            choice = choice.toUpperCase();

            Player player = Potterheads.getPlayer();

            ArrayList<Spell> spellInventory = player.getSpells();
            Spell lumos = new Spell(Spell.SpellType.lumos);

            switch (choice) {
                case "LUMOS":
                    if (!((Potterheads.getCurrentGame().getSpellInventory().contains(lumos)))) {
                        this.console.println("\nYou haven't learned this spell yet.");
                    } else {
                        if (!player.isHasClearedDarkRoom()) {
                            this.console.println("\nYou use lumos and the room lights up\n"
                                    + "immediately. You see an old dungeon that seems to have\n"
                                    + "gone unvisited in several months, maybe even years. Over\n"
                                    + "in the corner of the room, an object catches your eye.\n"
                                    + "You wander over and pick it up only to discover that it's\n"
                                    + "an ornate walking stick. You hold onto it. This walking stick might\n"
                                    + "belong to someone.");

                            player.setHasClearedDarkRoom(true);
                            
                            Potterheads.getPlayer().getInventoryItems().add(new InventoryItem(InventoryItemType.walkingStick));
                            this.showAcquiredItem();

                        } else {
                            this.console.println("\nYou use lumos and the room lights up\n"
                                    + "immediately. You see an old dungeon that seems to have\n"
                                    + "gone unvisited in several months, maybe even years. It's empty now.");
                        }
                    }
                    return true;

                case "STUPIFY":
                    this.console.println("\nNothing happened.");
                    break;
                case "SECTUMSEMPRA":
                    this.console.println("\nNothing happened.");
                    break;
                case "PETRIFICUS TOTALUS":
                    this.console.println("\nNothing happened.");
                    break;
                case "WINGARDIUM LEVIOSA":
                    this.console.println("\nNothing happened.");
                    break;
                case "EXPELLIARMUS":
                    this.console.println("\nNothing happened.");
                    break;
                case "Q":
                    return true;
                default:
                    ErrorView.display(this.getClass().getName(), "Invalid selection. Choose one of the items from the list.");
                    break;
            }

        }
        return false;
    }

    private boolean showAcquiredItem() {
        StringBuilder line;

        Game game = Potterheads.getCurrentGame();
//        InventoryItem[] inventory = game.getInventory();

        ArrayList<InventoryItem> inventory = game.getTradeableInventory();

        this.console.println("\n          List of Acquired Items");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "Description");
        this.console.println(line.toString());

        //for each inventory item
        for (InventoryItem tradeableInventory : inventory) {
            line = new StringBuilder("                                                  ");
            line.insert(0, tradeableInventory.getName());
            line.insert(25, tradeableInventory.getDescription());

            //Display the line
            this.console.println(line.toString());
        }
        return true;
    }
}
