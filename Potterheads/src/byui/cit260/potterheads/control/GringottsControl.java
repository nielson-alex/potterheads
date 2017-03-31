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

import byui.cit260.potterheads.exceptions.GringottsControlException;
import byui.cit260.potterheads.exceptions.PolyjuiceControlException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author alex
 */
public class GringottsControl extends Exception {
    protected final PrintWriter console = Potterheads.getOutFile();

    DecimalFormat df = new DecimalFormat("#.00");

    Scanner inFile;

    public double convertUsdToGalleons(double dollars, double cents) 
            throws GringottsControlException {
        if (dollars < 5) {
            throw new GringottsControlException("\nYou need to exchange at least 5 USD.");
        }

        if (dollars > 500) {
            throw new GringottsControlException("\nYou don't have that much money.");
        }

        if (cents < 0) {
            throw new GringottsControlException("\nYou can't exchange negative cents.");
        }

        if (cents >= 100) {
            throw new GringottsControlException("\nThat would just another dollar.");
        }

        double galleons = (dollars + (cents * .01)) * 0.735;

        this.console.println("\nYou exchanged " + dollars + " dollars and " + cents
                + " cents for " + df.format(galleons) + " galleons.");

        return galleons;
    }
}
