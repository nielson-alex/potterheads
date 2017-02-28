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
public class NimbusView {

//    private String menu;
//    //private String promptMessage;
//
//    public NimbusView() {
//        this.menu = "\nYou've chosen to ride the Nimbus 2000. This is a\n"
//                + "medium-speed broom that can fly anywhere between 50 and 90\n"
//                + "miles per hour. The goal is to try catch the golden snitch\n"
//                + "in under 3 minutes. Good luck!\n\n"
//                + "First, enter the speed you want to fly in miles per hour:\n\n"
//                + "(press 'Q' to exit)";
//    }
    public void displayNimbusView() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String response = "";
        boolean done = false;

        while (!done) {
            System.out.println("\nYou've chosen to fly the Nimbus 2000. This is a\n"
                    + "medium-speed broom that can fly anywhere between 50 and 90\n"
                    + "miles per hour. Remember that you only have between 1 and\n"
                    + "3 minutes to catch the snitch.\n\n"
                    + "Do you still want to fly the Nimbus 2000?");

            response = keyboard.nextLine();
            response = response.trim();

            if (response.length() < 1) {
                System.out.println("\nInvalid value: value cannot be blank.");
                continue;
            }

            break;
        }

        if ("Y".equals(response.toUpperCase())) {

            do {
                String nimbusSpeed = this.getNimbusSpeed();
                if (nimbusSpeed.toUpperCase().equals("Q")) {
                    return;
                }

                String timeOnBroom = this.getTimeOnBroom();

                double nimbusSpeedD = Double.parseDouble(nimbusSpeed);
                double timeOnBroomD = Double.parseDouble(timeOnBroom);

                done = this.doAction(nimbusSpeedD, timeOnBroomD);

            } while (!done);
        } else if ("N".equals(response.toUpperCase())) {
            return;
        } else {
            System.out.println("\nPlease enter 'y' or 'n'");
        }
    }

    private String getNimbusSpeed() {

        Scanner keyboard = new Scanner(System.in); // get infile for keyboard 
        String nimbusSpeed = ""; //value to be returned
        boolean valid = false; // initialize to not valid

        while (!valid) { // loop while an invalid value is entered
            System.out.println("\nGreat! So enter the speed you want to fly in\n"
                    + "miles per hour: ");

            nimbusSpeed = keyboard.nextLine(); // get next line typed on keyboard
            nimbusSpeed = nimbusSpeed.trim(); // trim off leading and trailing blanks

            if (nimbusSpeed.length() < 1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }

            break; // end the loop
        }

        return nimbusSpeed; // return the value entered
    }

    private String getTimeOnBroom() {

        Scanner keyboard = new Scanner(System.in); // get infile for keyboard 
        String timeOnBroom = ""; //value to be returned
        boolean valid = false; // initialize to not valid

        while (!valid) { // loop while an invalid value is entered
            System.out.println("\nNow enter the time you want to fly in seconds:\n");

            timeOnBroom = keyboard.nextLine(); // get next line typed on keyboard
            timeOnBroom = timeOnBroom.trim(); // trim off leading and trailing blanks

            if (timeOnBroom.length() < 1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }

            break; // end the loop
        }

        return timeOnBroom; // return the value entered
    }

    private boolean doAction(double nimbusSpeedD, double timeOnBroomD) {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcNimbusTime(nimbusSpeedD, timeOnBroomD);

        returnToScreen();

        return true;
    }

    private void returnToScreen() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String response = "";
        boolean done = false;

        while (!done) {
            System.out.println("\nCongratulations! You've successfully caught the\n"
                    + "snitch! Would you like to ride again?\n\n"
                    + "(choose 'y' for yes or 'n' for no)");

            response = keyboard.nextLine();
            response = response.trim();

            if (response.length() < 1) {
                System.out.println("\nInvalid value: value cannot be blank.");
                continue;
            }

            break;
        }

        if ("N".equals(response.toUpperCase())) {
            return;
        } else if ("Y".equals(response.toUpperCase())) {
            this.displayNimbusView();
        } else {
            System.out.println("\nLook, we said pick 'y' or 'n', it's not that hard.");
        }
    }
}
