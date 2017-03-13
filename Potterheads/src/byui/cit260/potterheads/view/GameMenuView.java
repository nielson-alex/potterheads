/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import java.util.ArrayList;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author aleecrook
 */
public class GameMenuView extends View {

    public ArrayList<InventoryItem> inventoryItems;

    public GameMenuView() {
        super("\nWe're still building our game. Select one of these\n"
                + "options to test the views we're working on.\n\n"
                + "D - Diagon Alley\n"
                + "P - Polyjuice Potion\n"
                + "W - Quidditch Pitch\n"
                + "I - View Inventory\n"
                + "M - View Map\n"
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
                this.quitGameMenuView();
                break;
            case "I":
                this.viewInventory(inventoryItems);
                break;
            case "M":
                this.displayMap();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
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
        System.out.println("\n***openPolyjuiceView() function called***");
    }

    // case "W"
    private void openQuidditchView() {
        QuidditchView quidditchView = new QuidditchView();
        quidditchView.display();
    }

// "case "Q"
    private void quitGameMenuView() {
        System.out.println("\n*** quit game ***");

    }

    private void viewInventory(ArrayList<InventoryItem> inventoryItems) {
        StringBuilder line;

        Game game = Potterheads.getCurrentGame();
//        InventoryItem[] inventory = game.getInventory();

        ArrayList inventory = game.getInventoryItems();

        System.out.println("\n          List of Inventory Items");
        line = new StringBuilder("                                                              ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "IN STOCK");
        System.out.println(line.toString());

        //for each inventory item
        for (InventoryItem inventoryItem : inventoryItems) {
            line = new StringBuilder("                                                  ");
            line.insert(0, inventoryItem.getName());
            line.insert(23, inventoryItem.getQuantityInStock());

            //Display the line
            System.out.println(line.toString());
        }
    }

    private void displayMap() {
        System.out.println("***display map function called***");
    }

}
