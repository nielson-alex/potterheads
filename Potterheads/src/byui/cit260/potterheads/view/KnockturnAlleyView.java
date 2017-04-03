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
import byui.cit260.potterheads.model.Spell.SpellType;
import java.util.ArrayList;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
class KnockturnAlleyView extends View {

    public KnockturnAlleyView() {
        super("\nYou see a man with long blonde hair in the alley. He keeps eyeing\n"
                + "you suspiciously. You think might recognize this man as Malfoy's\n"
                + "father.\n\n"
                + "'Leave me be,' Lucius growls at you. 'Someone has\n"
                + "stolen my walking stick. It's a priceless family heirloom and. I need it back immediately.\n"
                + "Until it's back in my possession, I have no time to waste entertaining\n"
                + "any annoying urchins who bother me. Now leave, or else I\n"
                + "Do you want to tell him you have his walking stick?\n\n"
                + "(press 'Y' for yes or 'N' for no");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;

        while (!done) {
            if ("Y".equals(value.toUpperCase())) {
                boolean hasWalkingStick = false;
                Player player = potterheads.Potterheads.getPlayer();

                for (InventoryItem item : player.getInventoryItems()) {
                    if (item.getType() == InventoryItem.InventoryItemType.walkingStick) {
                        hasWalkingStick = true;
                    }
                }

                if (hasWalkingStick == true) {
                    this.console.println("\nYou offer the walking stick to Lucius.\n"
                            + "'Where did you find this?' He demands angrily. His\n"
                            + "expression then changes suddenly. 'Hm. I suppose it doesn't\n"
                            + "matter, so long as I have it back now. As a thank you, I'll\n"
                            + "teach you a spell that will prove useful to you in your future.'");

                    player.getInventoryItems().remove(new InventoryItem(InventoryItemType.walkingStick));
                    player.getSpells().add(new Spell(SpellType.avadaKedavra));

                    StringBuilder line;
                    Game game = Potterheads.getCurrentGame();
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
                } else {
                    this.console.println("\nYou don't have the walking stick.");
                    return true;
                }
//                this.giveStick();
            } else if ("N".equals(value.toUpperCase())) {
                return true;
            } else {
                this.console.println("\nInvalid. Try again.");
            }
            break;
        }
        return true;
    }
}
