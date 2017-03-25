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
                + "D - Diagon Alley\n"
                + "P - Polyjuice Potion\n"
                + "W - Quidditch Pitch\n"
                + "I - View Inventory\n"
                + "V - View Spells\n"
                + "M - View Map\n"
                + "G - Get Money\n"
//                + "S - Save game\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();

        switch (choice) {
            case "D":
                this.openDiagonAlleyView();
                break;
            case "P":
                this.openPolyjuiceView();
                break;
            case "W":
                this.openQuidditchView();
                break;
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
                ErrorView.display(this.getClass().getName(), "you must enter a value.");
                break;
        }
        return false;

    }

    // case "D"
    private void openDiagonAlleyView() {
        DiagonAlleyView diagonAlleyView = new DiagonAlleyView();
        diagonAlleyView.display();
    }

    // case "P"
    private void openPolyjuiceView() {
        PolyjuiceView polyjuiceView = new PolyjuiceView();
        polyjuiceView.display();
    }

    // case "W"
    private void openQuidditchView() {
        QuidditchView quidditchView = new QuidditchView();
        quidditchView.display();
    }

// "case "Q"
    private void quitGameMenuView() {
        this.console.println("\n*** quit game ***");

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
        StringBuilder line;

        Map map = Potterheads.getCurrentGame().getMap();
        Location[][] locations = map.getLocations();

        this.console.println("MAP");

        line = new StringBuilder();
        StringBuilder hyphens = new StringBuilder();
        line.append("  ");
        hyphens.append("  ");

        for (int i = 1; i <= locations.length; i++) {
            line.append(i);
            line.append("    ");
            hyphens.append("-----");
        }

        this.console.println(line.toString());
        this.console.println(hyphens.toString());

        for (int rowIndex = 0; rowIndex < locations.length; rowIndex++) {
            line = new StringBuilder("");
            line.append(rowIndex + 1);

            Location[] row = locations[rowIndex];

            for (Location column : row) {
                line.append("| ");
                line.append(column.getScene().getMapSymbol());
                line.append(" ");
            }
            line.append("|");
            this.console.println(line.toString());
            this.console.println(hyphens.toString());
        }

//        StringBuilder line;
//        
//        int[][] locations = Map.getLocations();
//        
//        for (Location)
    }

    private void displayGetSpellView() {
        GetSpellView getSpellView = new GetSpellView();
        getSpellView.display();
    }

}
