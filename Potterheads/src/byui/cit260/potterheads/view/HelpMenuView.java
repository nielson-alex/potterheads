/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.GameControl;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author aleecrook
 */
public class HelpMenuView {

    private String menu;
    //private String promptMessage;

    public HelpMenuView() {
        this.menu = "H - How to play\n"
                + "M - Movement\n"
                + "S - Stuck / Lost\n" 
                + "Q - Quit";
   }

    public void displayHelpMenuView() {
        boolean done = false;
        do {
            String menuOption = this.getHelpMenuOption();
            if (menuOption.toUpperCase().equals("Q")) {
                return;
            }

            done = this.doAction(menuOption);

        } while (!done);
    }

    private String getHelpMenuOption() {
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
            case "H":
                this.displayHowToPlay();
                break;
            case "M":
                this.displayMovementControls();
                break;
            case "S":
                this.displayHints();
                break;
            case "Q":
                this.quitHelpMenu();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

//    private void startNewGame() {
//        GameControl.createNewGame(Potterheads.getPlayer());
//        GameMenuView gameMenu = new GameMenuView();
//        gameMenu.displayMenu();
//    }
    
    // case "H"
    private void displayHowToPlay() {
        System.out.println("\n *** displayHowToPlay() function called ***");
    }

    // case "M"
    private void displayMovementControls() {
        System.out.println("\n *** displayMovementControls() function called ***");
    }
    
    // case "S"
    private void displayHints() {
        System.out.println("\n *** displayHints() function called***");
    }
    
    // case "Q"
    private void quitHelpMenu() {
        System.out.println("\n *** quitHelpMenu() function called ***");
    }


}
