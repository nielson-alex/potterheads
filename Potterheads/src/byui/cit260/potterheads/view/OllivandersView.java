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
                + "T - Taser            ʛ367.50\n"
                + "W - Backup Wand      ʛ250.00\n"
                + "F - Firecrackers     ʛ33.08\n"
                + "C - Chocolate Frogs  ʛ15.00\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        InventoryItem replacementWand = new InventoryItem(InventoryItemType.replacementWand);
        InventoryItem firecrackers = new InventoryItem(InventoryItemType.firecrackers);
        InventoryItem chocolateFrogs = new InventoryItem(InventoryItemType.chocolateFrogs);

        Player player = potterheads.Potterheads.getPlayer();

        switch (value) {
            case "T":
                boolean hasTaser = false;

                for (InventoryItem item : player.getInventoryItems()) {
                    if (item.getType() == InventoryItemType.taser) {
                        hasTaser = true;
                    }
                }

                if (!(hasTaser == true)) {
                    if (player.getGalleons() >= 367.5) {
                        player.setGalleons(player.getGalleons() - 376.5);
                        player.getInventoryItems().add(new InventoryItem(InventoryItemType.taser));
                        this.console.println("\nCongratulations! You have purchased a backup wand!\n"
                                + "Yours seems pretty reliable, but this might come in handy regardless.");
                    } else {
                        this.console.println("\nSorry, you don't have enough money.");
                    }
                } else {
                    this.console.println("\nYou already have this item.");
                }
                break;

            case "W":
                if (!(player.getInventoryItems().contains(replacementWand))) {
                    if (player.getGalleons() >= 250) {
                        player.setGalleons(player.getGalleons() - 250);
                        player.getInventoryItems().add(replacementWand);
                        this.console.println("\nCongratulations! You have purchased a backup wand!\n"
                                + "Yours seems pretty reliable, but this might come in handy regardless.");
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
