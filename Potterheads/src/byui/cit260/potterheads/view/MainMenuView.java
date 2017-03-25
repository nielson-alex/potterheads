/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.util.Scanner;
import byui.cit260.potterheads.control.GameControl;
import java.io.PrintWriter;
import potterheads.Potterheads;

/**
 *
 * @author aleecrook
 */
public class MainMenuView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

    public MainMenuView() {
        super("\n"
                + "---------------------------------\n"
                + "|            Main Menu           |\n"
                + "---------------------------------\n"
                + "N - New game\n"
                + "L - Load existing game\n"
                + "H - Help menu\n"
                + "G - Gameplay menu\n"
                + "S - Save game\n"
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
            case "S":
                this.saveGame();
                break;
            case "Q":
                this.quitGame();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid selection, try again.");
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
//            this.console.println(e.getMessage());
//        }

        //display game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    // case "L"
    private void displayExistingGame() {
        this.console.println("\nEnter the file path for the file of the game you want to load: ");
        
        String filePath = this.getInput();
        
        try {
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuview", ex.getMessage());
        }
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();

    }

    // case "H"
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    // case "G"
    private void displayGameMenu() {
        this.console.println("\n*** displayGameMenu() function called ***");
    }


    // case "S"
    private void saveGame() {
        this.console.print("\nEnter the file path for the file where the game will be saved: ");
        
        String filePath = this.getInput();
        
        try {
            GameControl.saveGame(Potterheads.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
    
        // "case "Q"
    private void quitGame() {
        System.exit(0);

    }

}
