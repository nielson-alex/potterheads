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
public class KitchenBroomView {

//    private String menu;
//    //private String promptMessage;
//
//    public KitchenBroomView() {
//        this.menu = "\nYou've chosen to ride the KitchenBroom 2000. This is a\n"
//                + "medium-speed broom that can fly anywhere between 50 and 90\n"
//                + "miles per hour. The goal is to try catch the golden snitch\n"
//                + "in under 3 minutes. Good luck!\n\n"
//                + "First, enter the speed you want to fly in miles per hour:\n\n"
//                + "(press 'Q' to exit)";
//    }
    public void displayKitchenBroomView() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String response = "";
        boolean done = false;

        while (!done) {
            System.out.println("\nYou've chosen to to fly the kitchen broom.\n"
                    + "Probabl not the wisest choice, considering that we're\n"
                    + "pretty sure someone put that out on the quidditch pitch\n"
                    + "as a joke and it's not intended for use in sports. Despite\n"
                    + "not being a sport broom, it can still attain speeds ranging\n"
                    + "from 10 to 40 miles per hour.\n"
                    + "The goal is try to catch the golden\n"
                    + "snitch between 1 and 3 minutes. Good luck!\n\n"
                    + "(press 'C' to continue or 'Q' to to return to the previous "
                    + "screen");

            response = keyboard.nextLine();
            response = response.trim();

            if (response.length() < 1) {
                System.out.println("\nInvalid value: value cannot be blank.");
                continue;
            } else if ("Q".equals(response.toUpperCase())) {
                return;
            } else if (!("C".equals(response.toUpperCase()))) {
                System.out.println("\nInvalid value: press 'C' to continue.");
                continue;
            }

            break;
        }

        String kitchenBroomSpeed = this.getKitchenBroomSpeed();
        if (kitchenBroomSpeed.toUpperCase().equals("Q")) {
            return;
        }

        String timeOnBroom = this.getTimeOnBroom();

        double kitchenBroomSpeedD = Double.parseDouble(kitchenBroomSpeed);
        double timeOnBroomD = Double.parseDouble(timeOnBroom);

        done = this.doAction(kitchenBroomSpeedD, timeOnBroomD);

    }

    private String getKitchenBroomSpeed() {

        Scanner keyboard = new Scanner(System.in); // get infile for keyboard 
        String kitchenBroomSpeed = ""; //value to be returned
        boolean valid = false; // initialize to not valid

        while (!valid) { // loop while an invalid value is entered
            System.out.println("\nGreat! So enter the speed you want to fly in\n"
                    + "miles per hour: ");

            kitchenBroomSpeed = keyboard.nextLine(); // get next line typed on keyboard
            kitchenBroomSpeed = kitchenBroomSpeed.trim(); // trim off leading and trailing blanks

            if (kitchenBroomSpeed.length() < 1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }

            break; // end the loop
        }

        return kitchenBroomSpeed; // return the value entered
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

    private boolean doAction(double kitchenBroomSpeedD, double timeOnBroomD) {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcKitchenBroomTime(kitchenBroomSpeedD, timeOnBroomD);

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
            this.displayKitchenBroomView();
        } else {
            System.out.println("\nLook, we said pick 'y' or 'n', it's not that hard.");
        }
    }
}
