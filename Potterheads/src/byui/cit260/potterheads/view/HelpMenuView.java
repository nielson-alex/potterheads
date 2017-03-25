/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.GameControl;
import java.io.PrintWriter;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author aleecrook
 */
public class HelpMenuView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

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
                ErrorView.display(this.getClass().getName(), "you must enter a value.");
                break;
        }
        return false;

    }

    // case "H"
    private void displayHowToPlay() {
        this.console.println("\n *** displayHowToPlay() function called ***");
    }

    // case "M"
    private void displayMovementControls() {
        this.console.println("\n *** displayMovementControls() function called ***");
    }

    // case "S"
    private void displayHints() {
        this.console.println("\n *** displayHints() function called***");
    }

    // case "Q"
    private void quitHelpMenu() {
        this.console.println("\n *** quitHelpMenu() function called ***");
    }
}
