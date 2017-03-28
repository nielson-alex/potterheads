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
import java.util.logging.Level;
import java.util.logging.Logger;
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
                + "snitch between 1 and 3 minutes.\n\n"
                + "First, enter the speed that you want to fly in miles per hour:\n"
                + "(press 'Q' to quit)");
    }

    @Override
    public boolean doAction(String value) 
        throws NumberFormatException {
        value = value.toUpperCase();
        
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);

        String kitchenBroomSpeed = value;
        String timeOnBroom = ""; //value to be returned
        double kitchenBroomSpeedDouble = 0;
        double timeOnBroomDouble = 0;

        while (!done) {
            if ("Q".equals(kitchenBroomSpeed.toUpperCase())) {
                return true;
            } else {
                try {
                    kitchenBroomSpeedDouble = Double.parseDouble(kitchenBroomSpeed);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number.");
                    return false;
                }
            }
            break;
        }

        while (!done) {
            this.console.println("\nNext enter the amount of time you want to fly in seconds.");

            timeOnBroom = keyboard.nextLine();

            if ("Q".equals(timeOnBroom.toUpperCase())) {
                return true;
            } else {
                try {
                    timeOnBroomDouble = Double.parseDouble(timeOnBroom);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number.");
                    continue;
                }
            }
            break;

        }
        try {
            this.calculateQuidditchControl(kitchenBroomSpeedDouble, timeOnBroomDouble);
        } catch (QuidditchControlException ex) {
            this.console.println(ex.getMessage());
        }
        return false;
    }

    private boolean calculateQuidditchControl(double kitchenBroomSpeedDouble, double timeOnBroomDouble)
            throws QuidditchControlException {
        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcKitchenBroomTime(kitchenBroomSpeedDouble, timeOnBroomDouble);

        return true;
    }
}
