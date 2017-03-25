/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

/**
 *
 * @author aleecrook
 */
import java.util.Scanner;
import byui.cit260.potterheads.control.PolyjuiceControl;
import java.io.PrintWriter;
import potterheads.Potterheads;

public class PolyjuiceView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

    public PolyjuiceView() {
        super("\nYou're in the potions laboratory where you have access to all of\n"
                + "the potions. Would like to brew the polyjuice potion now?\n"
                + "asks you if you would like to make any currency exchanges.\n\n"
                + "(press 'C' to continue or 'Q' to go back");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;
        double weightDouble = 0;
        double ozOfPotionDouble = 0;

        while (!done) {
            String pressC = "\n*** press 'C' to continue or 'Q' to go back ***";

            if ("C".equals(value.toUpperCase())) {
                this.calcTimeTransformed(weightDouble, ozOfPotionDouble);
            } else if (!("C".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
                this.console.println(pressC);
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            }
            break;
        }
        return false;
    }

    private boolean calcTimeTransformed(double weightDouble, double ozOfPotionDouble) {
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);
        String weight = "";
        String ozOfPotion = ""; //value to be returned

        while (!done) {
            this.console.println("\nFirst enter your weight:\n");

            weight = keyboard.nextLine();

            if (weight.length() < 1) {
                ErrorView.display(this.getClass().getName(), "you must enter a value.");
                continue;
            } else if ("Q".equals(weight.toUpperCase())) {
                return true;
            } else {
                try {
                    weightDouble = Double.parseDouble(weight);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "you must enter a value.");
                    continue;
                }
            }
            break;
        }

        while (!done) {

            this.console.println("\nNext enter the number of fluid ounces of polyjuice\n"
                    + "potion you that you want to brew (remember that your flask\n"
                    + "can only hold up 5 ounces of liquid):");

            ozOfPotion = keyboard.nextLine();

            if (ozOfPotion.length() < 1) {
                ErrorView.display(this.getClass().getName(), "you must enter a value.");
                continue;
            } else if ("Q".equals(ozOfPotion.toUpperCase())) {
                return true;
            } else {
                try {
                    ozOfPotionDouble = Double.parseDouble(ozOfPotion);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "you must enter a value.");
                    continue;
                }
            }
            break;
        }

        PolyjuiceControl polyjuiceControl = new PolyjuiceControl();
        polyjuiceControl.calcTimeTransformed(weightDouble, ozOfPotionDouble);

        // return to previous view;
        return true;
    }
}
