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
 * @author alex
 */
public class QuidditchView {
    private String menu;
    //private String promptMessage;

    public QuidditchView() {
        this.menu = "\n All right fool, pick a broom you want to ride.\n"
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
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcNimbusTime(0, 0);
    }
    
    // case "F"
    private void rideFirebolt() {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcFireboltTime(0, 0);
    }
    
// case "N"
    private void rideKitchenBroom() {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcKitchenBroomTime(0, 0);
    }
    
// "case "Q"
    private void quitQuidditchView() {
        System.out.println("\n*** quit game ***");

    }

}
