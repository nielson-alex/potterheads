/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// step 2 Alex
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.GringottsControl;
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
        super("\nYou enter Gringotts Bank, where an old troll behind the counter\n"
                + "asks you if you would like to make any currency exchanges.\n\n"
                + "A: Exchange Money:\n"
                + "Q: Exit;");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;
        double dollarsDouble = 0;
        double centsDouble = 0;

        while (!done) {
            String pressA = "\n*** press 'A' to exchange currency or 'Q' to quit ***";

            if ("A".equals(value.toUpperCase())) {
                this.convertUsdToGalleons(dollarsDouble, centsDouble);
            } else if (!("A".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
                this.console.println(pressA);
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            }
            break;
        }
        return false;
    }

    private boolean convertUsdToGalleons(double dollarsDouble, double centsDouble) {
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);
        String dollars = "";
        String cents = ""; //value to be returned

        while (!done) {
            this.console.println("\nFirst enter the number of dollars you want to convert\n"
                    + "(use a whole number):");

            dollars = keyboard.nextLine();

            if (dollars.length() < 1) {
                ErrorView.display(this.getClass().getName(), "you must enter a value.");
                continue;
            } else if ("Q".equals(dollars.toUpperCase())) {
                return true;
            }
            break;
        }

        while (!done) {

            this.console.println("\nNext enter the number of cents you want to convert\n"
                    + "(use a whole number):");

            cents = keyboard.nextLine();

            if (cents.length() < 1) {
                ErrorView.display(this.getClass().getName(), "you must enter a value.");
                continue;
            } else if ("Q".equals(cents.toUpperCase())) {
                return true;
            }
            break;
        }

        dollarsDouble = Double.parseDouble(dollars);
        centsDouble = Double.parseDouble(cents);

        GringottsControl diagonAlleyControl = new GringottsControl();
        diagonAlleyControl.convertUsdToGalleons(dollarsDouble, centsDouble);

        // return to previous view;
        return true;
    }
}
