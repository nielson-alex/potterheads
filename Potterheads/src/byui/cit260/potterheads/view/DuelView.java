/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import static byui.cit260.potterheads.model.InventoryItem.InventoryItemType.gun;
import byui.cit260.potterheads.model.Player;
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
                + "Do you want to use an item or a spell against Malfoy?\n"
                + "(press 'I' for Item, 'S' for spell, or 'Q' to quit");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;
        
        while (!done) {
            if ("I".equals(value.toUpperCase())) {
                this.useItem();
            } else if ("S".equals(value.toUpperCase())) {
                this.useSpell();
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            }
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
            case "GUN":
                if (!(player.getInventoryItems().contains(new InventoryItem(gun)))) {                    
                    this.console.println("\nYou don't even have this.");
                } else {
                    this.console.println("\n'Avada Kedavra!' you scream as you shoot Malfoy.\n"
                            + "Holy cow, you're a psycho.\n"
                            + "You go to Azkaban for the rest of your life.\n\n"
                            + "Game over.");
                    System.exit(0);
                }
                break;
            default:
                this.console.println("\nEnter a valid selection.");
                break;
        }
        return false;
    }

    private void useSpell() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
