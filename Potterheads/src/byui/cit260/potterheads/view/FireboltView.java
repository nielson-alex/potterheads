/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// step 2 Alex
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
import byui.cit260.potterheads.exceptions.QuidditchControlException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class FireboltView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();

    public FireboltView() {
        super("\nYou've chosen to to fly the Firebolt. This\n"
                + "is a high performance broom that has a minimum speed of\n"
                + "of 100 miles per hour. There's no known maximum speed for\n"
                + "this broom, but Hogwarts administration has placed the\n"
                + "limit at 150 miles per hour.\n"
                + "The goal is try to catch the golden\n"
                + "snitch between 1 and 3 minutes. \n\n"
                + "First enter the speed you want to fly in miles per hour: \n"
                + "(press 'Q' to quit)");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;

        Scanner keyboard = new Scanner(System.in);

        String fireboltSpeed = value;
        double fireboltSpeedDouble = 0;
        String timeOnBroom = "";
        double timeOnBroomDouble = 0;

        while (!done) {
            if ("Q".equals(fireboltSpeed.toUpperCase())) {
                return true; 
            } else {
                try {
                    fireboltSpeedDouble = Double.parseDouble(fireboltSpeed);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number.");
                    return false;
                }
            }
            break;
        }

        while (!done) {
            this.console.println("\nNext enter the amount of time that you want to (in seconds): ");

            timeOnBroom = keyboard.nextLine();

            if ("Q".equals(timeOnBroom.toUpperCase())) {
                return true;
            } else {
                try {
                    timeOnBroomDouble = Double.parseDouble(timeOnBroom);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number.");
                    continue;
                }
            }
            break;
        }

        try {
            this.calculateQuidditchControl(fireboltSpeedDouble, timeOnBroomDouble);
        } catch (QuidditchControlException ex) {
            this.console.println(ex.getMessage());
        }

        return true;
    }

    private boolean calculateQuidditchControl(double fireboltSpeedDouble, double timeOnBroomDouble)
            throws QuidditchControlException {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcFireboltTime(fireboltSpeedDouble, timeOnBroomDouble);

        // return to previous view;
        return true;
    }
}
