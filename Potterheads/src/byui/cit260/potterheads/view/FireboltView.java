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
public class FireboltView extends View {

    public FireboltView() {
        super("\nYou've chosen to to fly the Firebolt. This\n"
                + "is a high performance broom that has a minimum speed of\n"
                + "of 100 miles per hour. There's no known maximum speed for\n"
                + "this broom, but Hogwarts administration has placed the\n"
                + "limit at 150 miles per hour.\n"
                + "The goal is try to catch the golden\n"
                + "snitch between 1 and 3 minutes. Good luck!\n\n"
                + "(press 'C' twice to continue or 'Q' to quit)");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        boolean done = false;

        while (!done) {
            String pressC = "\n(press 'C' to continue or 'Q' to quit)";

            value = keyboard.nextLine();

            if ("C".equals(value.toUpperCase())) {
                break;
            }
            
            else if(!("C".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
                System.out.println(pressC);
                continue;
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            } 
            break;
        }

        String fireboltSpeed = "";
        String timeOnBroom = ""; //value to be returned

        while (!done) {
            System.out.println("\nFirst enter the speed you want to go in miles per"
                    + " hour.");

            fireboltSpeed = keyboard.nextLine();

            if (fireboltSpeed.length() < 1) {
                System.out.println("\n*** Value cannot be blank ***");
                continue;
            } else if ("Q".equals(fireboltSpeed.toUpperCase())) {
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

        double fireboltSpeedDouble = Double.parseDouble(fireboltSpeed);
        double timeOnBroomDouble = Double.parseDouble(timeOnBroom);

        this.calculateQuidditchControl(fireboltSpeedDouble, timeOnBroomDouble);

        return false;
    }

    private boolean calculateQuidditchControl(double fireboltSpeedD, double timeOnBroomD) {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcFireboltTime(fireboltSpeedD, timeOnBroomD);

        // return to previous view;
        return true;
    }
}
