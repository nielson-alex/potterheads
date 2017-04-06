/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.exceptions.GringottsControlException;
import byui.cit260.potterheads.model.Player;
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

    double money = potterheads.Potterheads.getPlayer().getMoney();

    double dollars = money;

    DecimalFormat df = new DecimalFormat("#.00");

    Scanner inFile;

    public double convertUsdToGalleons(double dollars, double cents)
            throws GringottsControlException {
        
        /*
        To throw a custom runtime error, you need to first create a custom
        exception class. In this case, we created the GringottsControlException
        which can be seen on line 32, thrown within the method signature. When
        the player inputs a value that doesn't fall within the parameters set 
        by the program, then it throws a new exception error and displays a 
        custom message.
        */
        if (dollars < 5) {
            throw new GringottsControlException("\nYou need to exchange at least 5 USD.");
        }

        if (dollars > potterheads.Potterheads.getPlayer().getMoney()) {
            throw new GringottsControlException("\nYou don't have that much money.");
        }

        if (cents < 0) {
            throw new GringottsControlException("\nYou can't exchange negative cents.");
        }

        if (cents >= 100) {
            throw new GringottsControlException("\nThat would just be another dollar.");
        }

        double galleons = ((dollars + cents) * 0.735);
        potterheads.Potterheads.getPlayer().setMoney(potterheads.Potterheads.getPlayer().getMoney() - (dollars + cents));

        this.console.println("\nYou exchanged " + dollars + " dollars and " + (cents * 100)
                + " cents for " + df.format(galleons) + " galleons.");

        potterheads.Potterheads.getPlayer().setGalleons(potterheads.Potterheads.getPlayer().getGalleons() + galleons);

        return galleons;
    }
}
