/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author alex
 */
public class PolyjuiceControl {

    DecimalFormat df = new DecimalFormat("#.00");

    Scanner inFile;

    public double calcTimeTransformed(double weight, double ozOfPotion) {

        if (weight < 90) {
            return -1;
        }

        if (weight > 300) {
            return -2;
        }

        if (ozOfPotion < 1) {
            return -3;
        }

        if (ozOfPotion > 5) {
            return -4;
        }

        double timeTransformed = (ozOfPotion * weight) / 60;

        System.out.println("\nYou exchanged have brewed enough polyjuice potion to\n"
                + "remain transformed for " + df.format(timeTransformed)
                + " minutes.");

        return timeTransformed;

    }
}
