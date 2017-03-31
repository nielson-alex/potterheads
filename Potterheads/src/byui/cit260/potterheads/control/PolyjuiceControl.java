/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.exceptions.PolyjuiceControlException;
import byui.cit260.potterheads.exceptions.QuidditchControlException;
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

        return timeTransformed;

    }
}
