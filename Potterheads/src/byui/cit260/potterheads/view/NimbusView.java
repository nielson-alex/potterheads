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
public class NimbusView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();

    public NimbusView() {
        super("\nYou've chosen to to fly the Nimbus 2000. This\n"
                + "is a medium-speed broom that can with a minimum speed of\n"
                + "of 50 miles per hour and a maximum speed of 90 miles per hour.\n"
                + "The goal is try to catch the golden\n"
                + "snitch between 1 and 3 minutes. Good luck!\n\n"
                + "First, enter the speed that you want to fly in miles per hour:\n"
                + "(press 'Q' to quit)");
    }

    @Override
    public boolean doAction(String value)
            throws NumberFormatException {

        value = value.toUpperCase();

        boolean done = false;
        Scanner keyboard = new Scanner(System.in);

        String nimbusSpeed = value;
        double nimbusSpeedDouble = 0;
        String timeOnBroom = "";
        double timeOnBroomDouble = 0;

        while (!done) {
//            String pressC = "\n*** Please press 'C' to continue or 'Q' to quit***";

            if ("Q".equals(nimbusSpeed.toUpperCase())) {
                return true;
            } else {
                try {
                    nimbusSpeedDouble = Double.parseDouble(nimbusSpeed);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number.");
                    return false;
                }
            }
            break;
        }

        while (!done) {
            this.console.println("\nNext, enter the amount of time you want to fly (in seconds): "
                    + " hour.");

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
            this.calculateQuidditchControl(nimbusSpeedDouble, timeOnBroomDouble);
        } catch (QuidditchControlException ex) {
            this.console.println(ex.getMessage());
        }
        return true;
    }

    private boolean calculateQuidditchControl(double nimbusSpeedDouble, double timeOnBroomDouble)
            throws QuidditchControlException {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcNimbusTime(nimbusSpeedDouble, timeOnBroomDouble);

        // return to previous view;
        return true;
    }
}
