/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// step 2 Alex
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
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
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        boolean done = false;

        if (!("C".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
            System.out.println("\n(press 'C' to continue or 'Q' to quit");
        }

        while (!done) {
            String pressC = "\n(press 'C' to continue or 'Q' to quit)";

            value = keyboard.nextLine();

            if (!("C".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
                System.out.println(pressC);
                continue;
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            }
            break;
        }

        String nimbusSpeed = "";
        String timeOnBroom = ""; //value to be returned

        while (!done) {
            System.out.println("\nFirst enter the speed you want to go in miles per"
                    + " hour.");

            nimbusSpeed = keyboard.nextLine();

            if (nimbusSpeed.length() < 1) {
                System.out.println("\n*** Value cannot be blank ***");
                continue;
            } else if ("Q".equals(nimbusSpeed.toUpperCase())) {
                return true;
            }
            break;
        }

        while (!done) {

            System.out.println("\nNext enter the amount of time you want to fly in seconds.");

            timeOnBroom = keyboard.nextLine();

            if (timeOnBroom.length() < 1) {
                System.out.println("\n*** Value cannot be blank ***");
                continue;
            } else if ("Q".equals(timeOnBroom.toUpperCase())) {
                return true;
            }
            break;
        }

        double nimbusSpeedDouble = Double.parseDouble(nimbusSpeed);
        double timeOnBroomDouble = Double.parseDouble(timeOnBroom);

        this.calculateQuidditchControl(nimbusSpeedDouble, timeOnBroomDouble);

        return false;
    }

    private boolean calculateQuidditchControl(double nimbusSpeedD, double timeOnBroomD) {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcNimbusTime(nimbusSpeedD, timeOnBroomD);

        // return to previous view;
        return true;
    }
}
