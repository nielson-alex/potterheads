/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// step 2 Alex
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.GringottsControl;
import byui.cit260.potterheads.exceptions.GringottsControlException;
import byui.cit260.potterheads.model.Player;
import java.io.PrintWriter;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class GringottsView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();
    
    
    public GringottsView() {
        super("\nEnter the number of dollars you want to exchange:\n\n"
                + "(press 'Q' to quit)");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);
        
        Player player = Potterheads.getPlayer();
        double money = player.getMoney();
        
        String dollars = value;
        String cents = ""; //value to be returned
        double dollarsDouble = 0;
        double centsDouble = 0;

        while (!done) {

            if ("Q".equals(value.toUpperCase())) {
                return true;
            } else {
                try {
                    dollarsDouble = Double.parseDouble(dollars);
                } catch (NumberFormatException nf) {
                    this.console.println(nf.getMessage());
                    return false;
                }
            }
            break;
        }

        while (!done) {
            this.console.println("\nNow enter the number of cents you want to convert\n"
                    + "(use a whole number):");

            cents = keyboard.nextLine();

            if (cents.length() < 1) {
                ErrorView.display(this.getClass().getName(), "You must enter a value.");
                continue;
            } else if ("Q".equals(cents.toUpperCase())) {
                return true;
            } else {
                try {
                    centsDouble = (Double.parseDouble(cents) * .01);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number.");
                    continue;
                }
                break;
            }
        }

        try {
            this.convertCurrency(dollarsDouble, centsDouble);
        } catch (GringottsControlException ex) {
            this.console.println(ex.getMessage());
        }
            return true;
    }
    
    private boolean convertCurrency(double dollarsDouble, double centsDouble) 
        throws GringottsControlException {
    
        GringottsControl gringottsControl = new GringottsControl();
        gringottsControl.convertUsdToGalleons(dollarsDouble, centsDouble);

        // return to previous view;
        return true;
    }
}
