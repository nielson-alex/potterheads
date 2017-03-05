/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
import byui.cit260.potterheads.view.ViewInterface.View;
import java.util.Scanner;

// Step 4
/**
 *
 * @author alex
 */
public class QuidditchView extends View {

    public QuidditchView() {
        super("\nYou find yourself in the courtyard of the Hogwarts castle.\n"
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
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String choice) {
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

    @Override
    public boolean doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
