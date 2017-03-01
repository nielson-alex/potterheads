/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
import java.util.Scanner;

// Step 4

/**
 *
 * @author alex
 */
public class QuidditchView {
    
//    // because the menu is defined within the QuidditchView class it can be
//    called globally and be used by any function within the class without having 
//    to be re-initialized or defined
    
    private String menu;
    //private String promptMessage;

    public QuidditchView() {
        this.menu = "\nYou find yourself in the courtyard of the Hogwarts castle.\n"
                + "You see a few students practicing their flying skills and milling\n"
                + "about but the field is mostly deserted because the quidditch\n"
                + "team is done with practice for the week.\n"
                + "You see a rack of brooms against one wall of the courtyard. Upon\n"
                + "close inspection you see that they're all either Nimbus 2000s\n"
                + "or Firebolts. There's also a busted up kitchen broom lying\n"
                + "on the ground\n"
                + "Pick a broom you would like to fly:.\n\n"
                + "N - Nimbus 2000\n"
                + "F - Firebolt\n"
                + "K - Kitchen Broom\n"
                + "Q - Quit";
    }

    public void displayQuidditchView() {
        boolean done = false;
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) {
                return;
            }

            done = this.doAction(menuOption);

        } while (!done);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard 
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid

        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.menu);

            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks

            if (value.length() < 1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }

            break; // end the loop
        }

        return value; // return the value entered
    }

    boolean doAction(String choice) {
        choice = choice.toUpperCase();

        switch (choice) {
            case "N":
                this.rideNimbus();
                break;
            case "F":
                this.rideFirebolt();
                break;
            case "K":
                this.rideKitchenBroom();
                break;
            case "Q":
                this.quitQuidditchView();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    // case "N"
    private void rideNimbus() {
        NimbusView nimbusView = new NimbusView();
        nimbusView.displayNimbusView();
    }

    // case "F"
    private void rideFirebolt() {
        FireboltView fireboltView = new FireboltView();
        fireboltView.displayFireboltView();
    }

// case "N"
    private void rideKitchenBroom() {
        KitchenBroomView kitchenBroomView = new KitchenBroomView();
        kitchenBroomView.displayKitchenBroomView();
    }

// "case "Q"
    private void quitQuidditchView() {
        System.out.println("\n*** quit game ***");

    }

}
