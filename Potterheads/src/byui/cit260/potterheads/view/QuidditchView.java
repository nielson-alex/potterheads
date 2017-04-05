/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.io.PrintWriter;
import potterheads.Potterheads;

/**
 *
 * @author alex
 */
public class QuidditchView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();

    public QuidditchView() {
        super("\n"
                + "Pick a broom you would like to fly:\n\n"
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
                ErrorView.display(this.getClass().getName(), "Invalid selection. Choose one of the items from the list.");
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
