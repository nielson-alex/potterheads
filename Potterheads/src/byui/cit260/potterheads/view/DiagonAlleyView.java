/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.util.Scanner;
import byui.cit260.potterheads.control.GringottsControl;
import java.io.PrintWriter;
import potterheads.Potterheads;

/**
 *
 * @author aleecrook
 */
public class DiagonAlleyView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

    public DiagonAlleyView() {
        super("Select which location you would like to visit:\n\n"
                + "A: The Leaky Cauldron\n"
                + "B: Gringotts\n"
                + "C: Ollivanders\n"
                + "D: Knockturn Alley\n"
                + "E: Flourish and Blotts\n"
                + "Q: Back to Main Menu");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "A":
                //Leaky Cauldron
                this.leakyCauldron();
                break;
            case "B":
                //Gringotts
                this.gringotts();
                break;
            case "C":
                //Ollivanders
                this.ollivanders();
                break;
            case "D":
                //Knockturn Alley
                this.knockturnAlley();
                break;
            case "E":
                //Flourish and Blotts
                this.flourishBlotts();
                break;
            case "Q":
                //Back to Main Menu
                return true;
            default:
                //Invalid Choice
                ErrorView.display(this.getClass().getName(), "Invalid selection. Choose one of the items from the list.");
        }

        return false;

    }

    private void leakyCauldron() {
        this.console.println("The aroma of Butterbeer fills your nostrils. You are in the Leaky Cauldron.");
    }

    private void gringotts() {

        GringottsView gringottsView = new GringottsView();
        gringottsView.display();

//        boolean error = true;
//        while (error) {
//            error = false;
//
//            this.console.println("A: Exchange Money\n"
//                    + "Q: Exit Gringotts");
//
//            String choice = this.getChoice();
//            if (choice.toUpperCase().equals("A")) {
//                //get conversion values
//                this.gringottsConversion();
//            } else if (choice.toUpperCase().equals("Q")) {
//                //Back to menu
//                this.console.println("Thanks for visiting Gringotts.");
//            } else {
//                error = true;
//                this.console.println("That is not an option. Pick again.");
//            }
//
//        }
    }

    private void gringottsConversion() {
        GringottsControl control = new GringottsControl();
        Scanner input = new Scanner(System.in);
        this.console.print("Enter the number of dollars(ex. 5): ");
        double dollars = input.nextDouble();
        this.console.print("Enter the number of cents with no decimal(ex. 45): ");
        double cents = input.nextDouble();
        this.console.println(control.convertUsdToGalleons(dollars, cents));
    }

    private void ollivanders() {
        this.console.println("The room is filled with boxes of wands. You are in Ollivanders.");
    }

    private void knockturnAlley() {
        this.console.println("You are surrounded by dark, dusty shops. You are in Knockturn Alley.");
    }

    private void flourishBlotts() {
        this.console.println("Books are stacked around the room. You are in Flourish and Blotts.");
    }
}
