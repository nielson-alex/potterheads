/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.util.Scanner;
import byui.cit260.potterheads.control.GameControl;
import potterheads.Potterheads;
/**
 *
 * @author aleecrook
 */
public class MainMenuView {
    
     private String menu;
    //private String promptMessage;
   public MainMenuView() {
       this.menu = "N - New game\n" +
            "L - Load existing game\n" +
            "H - Help menu\n" +
            "G - Gameplay menu\n" +
            "Q - Quit";
   }

    public void displayMainMenuView() {
        boolean done = false;
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(menuOption);
            
        } while (!done);
    }
    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard 
        String value =""; //value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.menu);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() <1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }
 
     boolean doAction(String choice) {
        choice = choice.toUpperCase();
        
        switch (choice){
            case "N":
                this.startNewGame();
                break;
            case "L":
                this.displayExistingGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "G":
                this.displayGameMenu();
                break;
            case "Q":
                this.quitGame();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
        
    }
     
    // case "N"
    private void startNewGame() {
       GameControl.createNewGame(Potterheads.getPlayer());
       GameMenuView gameMenu = new GameMenuView();
       gameMenu.displayMenu();
    }
    
    // case "L"
    private void displayExistingGame() {
        System.out.println("\n*** displayExistingGame() function called ***");
        
    }

    // case "H"
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }
    
    // case "G"
    private void displayGameMenu() {
        System.out.println("\n*** displayGameMenu() function called ***");
    }
    
    // "case "Q"
    private void quitGame() {
        System.out.println("\n*** quit game ***");
       
    }

    
    
}
