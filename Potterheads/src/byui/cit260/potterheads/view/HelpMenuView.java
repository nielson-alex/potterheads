/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.GameControl;
import byui.cit260.potterheads.view.ViewInterface.View;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author aleecrook
 */
public class HelpMenuView extends View {
    
    public HelpMenuView() {
        super("H - How to play\n"
                + "M - Movement\n"
                + "S - Stuck / Lost\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String choice) {
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

    @Override
    public boolean doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
