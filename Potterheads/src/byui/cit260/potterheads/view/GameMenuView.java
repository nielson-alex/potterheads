/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.Location;
import byui.cit260.potterheads.model.Map;
import byui.cit260.potterheads.model.Spell;
import java.util.ArrayList;
import java.util.Scanner;
import potterheads.Potterheads;
import byui.cit260.potterheads.control.GameControl;
import java.io.PrintWriter;

/**
 *
 * @author aleecrook
 */
public class GameMenuView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

    public GameMenuView() {
        super("\nWe're still building our game. Select one of these\n"
                + "options to test the views we're working on.\n\n"
                + "----------------------------------\n"
                + "|            Game Menu           |\n"
                + "----------------------------------\n"
                + "I - View Inventory\n"
                + "V - View Spells\n"
                + "M - View Map\n"
//                + "S - Save game\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();

        switch (choice) {
            case "Q":
                return true;
//                break;
            case "I":
                this.viewInventory();
                break;
            case "V":
                this.viewSpells();
                break;
            case "M":
                this.displayMap();
                break;
            case "G":
                this.displayGetSpellView();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid selection. Choose one of the items from the list.");
                break;
        }
        return false;
    }

    private void viewInventory() {
        StringBuilder line;

        Game game = Potterheads.getCurrentGame();
//        InventoryItem[] inventory = game.getInventory();

        ArrayList<InventoryItem> inventory = game.getTradeableInventory();

        this.console.println("\n          List of Inventory Items");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "DESCRIPTION");
        line.insert(50, "QUANTITY");
        this.console.println(line.toString());

        //for each inventory item
        for (InventoryItem tradeableInventory : inventory) {
            line = new StringBuilder("                                                  ");
            line.insert(0, tradeableInventory.getName());
            line.insert(25, tradeableInventory.getDescription());
            line.insert(50, tradeableInventory.getQuantityInStock());

            //Display the line
            this.console.println(line.toString());
        }

        GameControl gameControl = new GameControl();
        this.console.println("You have " + gameControl.getInventoryCount() + "/" + inventory.size() + " items.");
    }

    private void viewSpells() {
        StringBuilder line;

        Game game = Potterheads.getCurrentGame();
//        InventoryItem[] inventory = game.getInventory();

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
    }

    private void displayMap() {
        MapView mapView = new MapView();
        mapView.display();
        
        boolean validAction = false;
        while (!validAction) {
            validAction = mapView.doAction(mapView.getInput());
        }
        


    }

    private void displayGetSpellView() {
        GetSpellView getSpellView = new GetSpellView();
        getSpellView.display();
    }

}
