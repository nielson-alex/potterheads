/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class NimbusView {

    private String menu;
    //private String promptMessage;

    public NimbusView() {
        this.menu = "\nYou've chosen to ride the Nimbus 2000. This is a\n"
                + "medium-speed broom that can fly anywhere between 50 and 90\n"
                + "miles per hour. The goal is to try catch the golden snitch\n"
                + "in under 3 minutes. Good luck!\n\n"
                + "First, enter the speed you want to fly in miles per hour:\n\n"
                + "(press 'Q' to exit)";
    }

    public void displayNimbusView() {

        boolean done = false;
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
    }

    private String getNimbusSpeed() {

        Scanner keyboard = new Scanner(System.in); // get infile for keyboard 
        String nimbusSpeed = ""; //value to be returned
        boolean valid = false; // initialize to not valid

        while (!valid) { // loop while an invalid value is entered
            System.out.println(this.menu);

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
            System.out.println("\nNow enter the time you want to fly:\n");

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

        return false;
    }
}
