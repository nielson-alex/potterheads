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
public class MainMenuView extends View {

    public MainMenuView() {
        super("\nN - New game\n"
                + "L - Load existing game\n"
                + "H - Help menu\n"
                + "G - Gameplay menu\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
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
        //creaet a new game
//        try  {
            
            GameControl.createNewGame(Potterheads.getPlayer());
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
        
        //display game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    // case "L"
    private void displayExistingGame() {
        System.out.println("\n*** displayExistingGame() function called ***");

    }

    // case "H"
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
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
