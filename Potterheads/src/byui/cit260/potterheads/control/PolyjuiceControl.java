/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.exceptions.PolyjuiceControlException;
import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.Player;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author alex
 */
public class PolyjuiceControl {

    protected final PrintWriter console = Potterheads.getOutFile();

    DecimalFormat df = new DecimalFormat("#.00");

    Scanner inFile;

    public double calcTimeTransformed(double weight, double ozOfPotion)
            throws PolyjuiceControlException {

        if (weight < 90) {
            throw new PolyjuiceControlException("\nYou need to weight at least 90 pounds for this to work.");
        }

        if (weight > 300) {
            throw new PolyjuiceControlException("\nYour flask can only hold 5 ounces and 5 ounces of potion won't accomodate that weight.");
        }

        if (ozOfPotion < 1) {
            throw new PolyjuiceControlException("\nYou need at least one ounce of potion for this to work.");
        }

        if (ozOfPotion > 5) {
            throw new PolyjuiceControlException("\nYour flask won't hold that much.");
        }

        double timeTransformed = (ozOfPotion * weight) / 60;

        this.console.println("\nYou exchanged have brewed enough polyjuice potion to\n"
                + "remain transformed for " + df.format(timeTransformed)
                + " minutes.");

        Player player = Potterheads.getPlayer();
        InventoryItem timeTurner = new InventoryItem(InventoryItem.InventoryItemType.timeTurner);

        if (timeTransformed >= 7.5) {
            if (!(player.getInventoryItems().contains(timeTurner))) {
                this.console.println("\nThe potion worked! You look just like Hermione now.\n"
                        + "McGonogal sees you and gives you the time turner.");

                player.getInventoryItems().add(timeTurner);
            } else {
                this.console.println("\nYou've already got the time turner, kid.");
            }
        } else {
            this.console.println("\nYou've only brewed enough potion to last "
                    + df.format(timeTransformed) + " minutes.\n"
                    + "That's not enough time to reach McGonogal before you change back.\n"
                    + "You wait for the effects of the potion to wear off so you can try again.");
        }

        return timeTransformed;

        //minimum weight = 90
        //maximum weight = 300
        //minimum ounces = 1
        //maximum ounces = 5
        //(ozOfPotion * weight) / 60)
        //minimum equation ((90 * 1) / 60) = 1.5 minutes
        //maximum equation ((300 * 5) / 60) = 25 minutes
        // between (90 * 3) 7.5 and (300 * 3) 15
    }
}
