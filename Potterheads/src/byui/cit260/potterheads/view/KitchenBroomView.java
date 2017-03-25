/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// step 2 Alex
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
import byui.cit260.potterheads.exceptions.QuidditchControlException;
import java.io.PrintWriter;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class KitchenBroomView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

    public KitchenBroomView() {
        super("\nYou've chosen to to fly the kitchen broom.\n"
                + "Probably not the wisest choice, considering that we're\n"
                + "pretty sure someone put that out on the quidditch pitch\n"
                + "as a joke and it's not intended for use in sports. Despite\n"
                + "not being a sport broom, it can still attain speeds ranging\n"
                + "from 10 to 40 miles per hour.\n"
                + "The goal is try to catch the golden\n"
                + "snitch between 1 and 3 minutes. Good luck!\n\n"
                + "(press 'C' to continue or 'Q' to quit)");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;

        while (!done) {
//            String pressC = "\n*** Please press 'C' to continue or 'Q' to quit***";

            if ("C".equals(value.toUpperCase())) {
                try {
                    this.getInputs();
                } catch (QuidditchControlException ne) {
                    this.console.println(ne.getMessage());
                }
            } else if (!("C".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
                ErrorView.display(this.getClass().getName(), "Press 'C' to continue or 'Q' to quit.");
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            }
            break;
        }
        return false;
    }

    public void getInputs()
            throws QuidditchControlException {
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);

        String kitchenBroomSpeed = "";
        String timeOnBroom = ""; //value to be returned
        double kitchenBroomSpeedDouble = 0;
        double timeOnBroomDouble = 0;

        while (!done) {
            this.console.println("\nFirst enter the speed you want to go in miles per"
                    + " hour.");

            kitchenBroomSpeed = keyboard.nextLine();

            if ("Q".equals(kitchenBroomSpeed.toUpperCase())) {
                return;
            } else {
                try {
                    kitchenBroomSpeedDouble = Double.parseDouble(kitchenBroomSpeed);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "you must enter a value.");
                    continue;
                }
            }
            break;
        }

        while (!done) {
            this.console.println("\nNext enter the amount of time you want to fly in seconds.");

            timeOnBroom = keyboard.nextLine();

            if ("Q".equals(timeOnBroom.toUpperCase())) {
                return;
            } else {
                try {
                    timeOnBroomDouble = Double.parseDouble(timeOnBroom);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "you must enter a value.");
                    continue;
                }
            }
            break;

        }
        this.calculateQuidditchControl(kitchenBroomSpeedDouble, timeOnBroomDouble);
    }

    private boolean calculateQuidditchControl(double kitchenBroomSpeedDouble, double timeOnBroomDouble)
            throws QuidditchControlException {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcKitchenBroomTime(kitchenBroomSpeedDouble, timeOnBroomDouble);

        return true;
    }
}
