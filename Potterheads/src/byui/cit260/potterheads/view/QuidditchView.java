/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
import java.io.PrintWriter;
import java.util.Scanner;
import potterheads.Potterheads;

// Step 4
/**
 *
 * @author alex
 */
public class QuidditchView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();

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
                return true;
//                break;
            default:
                ErrorView.display(this.getClass().getName(), "you must enter a value.");
                break;
        }
        return false;

    }

    // case "N"
    private void rideNimbus() {
        NimbusView nimbusView = new NimbusView();
        nimbusView.display();
    }

    // case "F"
    private void rideFirebolt() {
        FireboltView fireboltView = new FireboltView();
        fireboltView.display();
    }

// case "N"
    private void rideKitchenBroom() {
        KitchenBroomView kitchenBroomView = new KitchenBroomView();
        kitchenBroomView.display();
    }

// "case "Q"
//    private void quitQuidditchView() {
//        return;
//    }

}
