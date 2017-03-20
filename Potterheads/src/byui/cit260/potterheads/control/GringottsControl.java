/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//define the problem
//design a solution
//develop the code
//test the code
//deploy the system
package byui.cit260.potterheads.control;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author alex
 */
public class GringottsControl {

    DecimalFormat df = new DecimalFormat("#.00");

    Scanner inFile;

    public double convertUsdToGalleons(double dollars, double cents) {
        if (dollars < 5) {
            return -1;
        }

        if (dollars > 500) {
            return -2;
        }

        if (cents <= 0) {
            return -3;
        }

        if (cents >= 100) {
            return -4;
        }

        double galleons = (dollars + (cents * .01)) * 0.735;

        System.out.println("\nYou exchanged " + dollars + " dollars and " + cents
                + " cents for " + df.format(galleons) + " galleons.");

        return galleons;
    }
}
