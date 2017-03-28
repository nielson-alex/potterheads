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
        super("\n'Hey,'" + Potterheads.getPlayer().getName() + "!' You hear a voice\n"
                + "call your name from across the quidditch pitch. You look up to see\n"
                + "Cedric Diggery greeting you."
                + "'So you want to try your hand at Quidditch? Well, I'm afraid that\n"
                + "all of the positions on the team are already filled. I'll tell you\n"
                + "what though, if you can can fly one of the brooms and catch the\n"
                + "snitch in a certain amount of time, I'll let you keep it. How does\n"
                + "that sound?' He asks.\n"
                + "He gestures across the Hogwards quidditch field to the opposite wall, where\n"
                + "you see a long rack containing dozens of different types of brooms.\n"
                + "'You can choose to ride a Nimbus 2000 or a Firebolt. Or if you're feeling\n"
                + "really confident, see you if you can catch the snith on a kitchen broom.'\n\n"
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
