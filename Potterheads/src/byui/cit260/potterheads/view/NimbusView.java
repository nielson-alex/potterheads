/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// step 2 Alex
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
import byui.cit260.potterheads.exceptions.QuidditchControlException;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class NimbusView extends View {

    public NimbusView() {
        super("\nYou've chosen to to fly the Nimbus 2000. This\n"
                + "is a medium-speed broom that can with a minimum speed of\n"
                + "of 50 miles per hour and a maximum speed of 90 miles per hour.\n"
                + "The goal is try to catch the golden\n"
                + "snitch between 1 and 3 minutes. Good luck!\n\n"
                + "(press 'C' to continue or 'Q' to quit)");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;

        while (!done) {
            String pressC = "\n*** Please press 'C' to continue or 'Q' to quit***";

            if ("C".equals(value.toUpperCase())) {
                try {
                    this.getInputs();
                } catch (QuidditchControlException ne) {
                    System.out.println(ne.getMessage());
                }
            } else if (!("C".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
                System.out.println(pressC);
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            }
            break;
        }
        return false;
    }

    public void getInputs()
            throws QuidditchControlException {
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);

        String nimbusSpeed = "";
        double nimbusSpeedDouble = 0;
        String timeOnBroom = "";
        double timeOnBroomDouble = 0;

        while (!done) {
            System.out.println("\nFirst enter the speed you want to go in miles per"
                    + " hour.");

            nimbusSpeed = keyboard.nextLine();

            if ("Q".equals(nimbusSpeed.toUpperCase())) {
                return;
            } else {
                try {
                    nimbusSpeedDouble = Double.parseDouble(nimbusSpeed);
                } catch (NumberFormatException nf) {
                    System.out.println("\nYou must enter a valid number." + "\n Try again "
                            + "or press 'Q' to quit.");
                    continue;
                }
            }
            break;
        }

        while (!done) {
            System.out.println("\nNext enter the amount of time you want to fly in seconds.");

            timeOnBroom = keyboard.nextLine();

            if ("Q".equals(timeOnBroom.toUpperCase())) {
                return;
            } else {
                try {
                    timeOnBroomDouble = Double.parseDouble(timeOnBroom);
                } catch (NumberFormatException nf) {
                    System.out.println("\nYou must enter a valid number." + "\n Try again "
                            + "or press 'Q' to quit.");
                    continue;
                }
            }
            break;

        }
        this.calculateQuidditchControl(nimbusSpeedDouble, timeOnBroomDouble);
    }

    private boolean calculateQuidditchControl(double nimbusSpeedDouble, double timeOnBroomDouble)
            throws QuidditchControlException {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcNimbusTime(nimbusSpeedDouble, timeOnBroomDouble);

        // return to previous view;
        return true;
    }
}
