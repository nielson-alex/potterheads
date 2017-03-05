/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.util.Scanner;
import byui.cit260.potterheads.control.GameControl;
import byui.cit260.potterheads.view.ViewInterface.View;
import potterheads.Potterheads;

/**
 *
 * @author aleecrook
 */
public class MainMenuView extends View {

    public MainMenuView() {
        super("N - New game\n"
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

//       int value = GameControl.createNewGame(Potterheads.getPlayer());
//       if (value < 0) {
//           System.out.println("Error -failed to create new game");
//       }
//       
        GameControl.createNewGame(Potterheads.getPlayer());
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

    @Override
    public boolean doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
