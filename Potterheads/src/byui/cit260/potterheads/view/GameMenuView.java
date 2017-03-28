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
import byui.cit260.potterheads.exceptions.GameControlException;
import byui.cit260.potterheads.model.Player;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            case "P":
                this.print();
                break;
            case "L":
                this.location();
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
//        MapView mapView = new MapView();
//        mapView.display();
//        
//        boolean validAction = false;
//        while (!validAction) {
//            validAction = mapView.doAction(mapView.getInput());
//        }
        StringBuilder line;
        
        Map map = Potterheads.getCurrentGame().getMap();
        Location[][] locations = map.getLocations();
        
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
        
        this.location();
    }

    private void displayGetSpellView() {
        GetSpellView getSpellView = new GetSpellView();
        getSpellView.display();
    }

    private void location() {
        Scanner keyboard = new Scanner(System.in);
        
        this.console.println("\nChoose where you would like to go on the map:\n"
                + "1. Diagon Alley             2. Polyjuice Potion Lab\n"
                + "3. Quidditch Pitch          4. Hagrid's House\n"
                + "5.                          6.\n"
                + "7.                          8.\n"
                + "9.                          10.\n"
                + "11.                         12.\n"
                + "13.                         14.\n"
                + "15.                         16.\n"
                + "17.                         18.\n"
                + "19.                         20.\n"
                + "21.                         22.\n"
                + "23.                         24.\n"
                + "25.\n\n"
                + "Q - quit");
       
        String selection = keyboard.nextLine();
        selection = selection.toUpperCase();
        
        switch (selection) {
            case "1":
                DiagonAlleyView diagonAlleyView = new DiagonAlleyView();
                diagonAlleyView.display();
                break;
            case "2":
                PolyjuiceView polyjuiceView = new PolyjuiceView();
                polyjuiceView.display();
                break;
            case "3":
                QuidditchView quidditchView = new QuidditchView();
                quidditchView.display();
                break;
            case "4":
                GetSpellView getSpellView = new GetSpellView();
                getSpellView.display();
                break;
            case "Q":
                return;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid selection. Choose an item from the map");
                break;
        };
    }

    private void print() {
        this.console.print("\nEnter the file path for the file where the game will be saved: ");
        
        String filePath = this.getInput();
        
        try {
            GameControl.print(Potterheads.getPlayer().getInventoryItems(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
   

    }


