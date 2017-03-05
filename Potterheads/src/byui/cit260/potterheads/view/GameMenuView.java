/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.view.ViewInterface.View;
import java.util.Scanner;

/**
 *
 * @author aleecrook
 */
public class GameMenuView extends View {

    public GameMenuView() {
        super("\nWe're still building our game. Select one of these\n"
                + "options to test the views we're working on.\n\n"
                + "D - Diagon Alley\n"
                + "P - Polyjuice Potion\n"
                + "W - Quidditch Pitch\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();

        switch (choice) {
            case "D":
                this.openDiagonAlleyView();
                break;
            case "P":
                this.openPolyjuiceView();
                break;
            case "W":
                this.openQuidditchView();
                break;
            case "Q":
                this.quitGameMenuView();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    // case "D"
    private void openDiagonAlleyView() {
        DiagonAlleyView diagonAlleyView = new DiagonAlleyView();
        diagonAlleyView.displayView();
    }

    // case "P"
    private void openPolyjuiceView() {
        System.out.println("\n***openPolyjuiceView() function called***");
    }

    // case "W"
    private void openQuidditchView() {
        QuidditchView quidditchView = new QuidditchView();
        quidditchView.display();
    }

// "case "Q"
    private void quitGameMenuView() {
        System.out.println("\n*** quit game ***");

    }

    @Override
    public boolean doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
