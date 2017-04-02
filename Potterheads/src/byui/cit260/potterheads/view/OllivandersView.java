/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.InventoryItem.InventoryItemType;
import byui.cit260.potterheads.model.Player;

/**
 *
 * @author Alex
 */
public class OllivandersView extends View {
    
    public OllivandersView() {
        super("\nWhat would you like to buy?\n\n"
                + "G - Gun              ʛ367.50\n"
                + "F - Firecrackers     ʛ33.08\n"
                + "C - Chocolate Frogs  ʛ15.00\n"
                + "Q - Quit");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        
        InventoryItem gun = new InventoryItem(InventoryItemType.gun);
        InventoryItem firecrackers = new InventoryItem(InventoryItemType.firecrackers);
        InventoryItem chocolateFrogs = new InventoryItem(InventoryItemType.chocolateFrogs);
        
        Player player = potterheads.Potterheads.getPlayer();
        
        switch(value) {
            case "G":
                if (!(player.getInventoryItems().contains(gun))) {
                    if (player.getGalleons() >= 367.50) {
                        player.setGalleons(player.getGalleons() - 376.50);
                        player.getInventoryItems().add(gun);
                        this.console.println("\nCongratulations! You have purchased " + gun.getName());
                    } else {
                        this.console.println("\nSorry, you don't have enough money.");
                    }
                } else {
                    this.console.println("\nYou already have this item.");
                }
                break;
            case "F": 
                if (!(player.getInventoryItems().contains(firecrackers))) {
                    if (player.getGalleons() >= 33.08) {
                        player.setGalleons(player.getGalleons() - 33.08);
                        player.getInventoryItems().add(firecrackers);
                        this.console.println("\nCongratulations! You have purchased " + firecrackers.getName());
                    } else {
                        this.console.println("\nSorry, you don't have enough money.");
                    }
                } else {
                    this.console.println("\nYou already have this item.");
                }
                break;
            case "C": 
                if (!(player.getInventoryItems().contains(chocolateFrogs))) {
                    if (player.getGalleons() >= 15.0) {
                        player.setGalleons(player.getGalleons() - 15.0);
                        player.getInventoryItems().add(chocolateFrogs);
                        this.console.println("\nCongratulations! You have purchased " + chocolateFrogs.getName());
                    } else {
                        this.console.println("\nSorry, you don't have enough money.");
                    }
                } else {
                    this.console.println("\nYou already have this item.");
                }
            case "Q":
                return true;
        }
        return false;
    }
}

