/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.Spell;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.util.ArrayList;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class PrintReportView {
    protected final PrintWriter console = Potterheads.getOutFile();
    StringBuilder line;

    Game game = Potterheads.getCurrentGame();
    ArrayList<InventoryItem> inventory = game.getTradeableInventory();
    
    public PrintReportView() {
    this.console.println("List of Inventory Items");
    
    this.console.println("\n          List of Spells Learned");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "EFFECT");
        this.console.println(line.toString());

        //for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            line = new StringBuilder("                                                  ");
            line.insert(0, inventoryItem.getName());
            line.insert(25, inventoryItem.getDescription());

            //Display the line
            this.console.println(line.toString() + "\n\n");
        }
    }
}
