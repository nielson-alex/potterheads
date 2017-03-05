/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// step 2 Alex
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.QuidditchControl;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class KitchenBroomView extends View {

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
        double kitchenBroomSpeedDouble = 0;
        double timeOnBroomDouble = 0;

        while (!done) {
            String pressC = "\n*** Please press 'C' to continue or 'Q' to quit***";

            if ("C".equals(value.toUpperCase())) {
                this.calculateQuidditchControl(kitchenBroomSpeedDouble, timeOnBroomDouble);
            } else if (!("C".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
                System.out.println(pressC);
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            }
            break;
        }
        return false;
    }

    private boolean calculateQuidditchControl(double kitchenBroomSpeedDouble, double timeOnBroomDouble) {
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);
        String kitchenBroomSpeed = "";
        String timeOnBroom = ""; //value to be returned

        while (!done) {
            System.out.println("\nFirst enter the speed you want to go in miles per"
                    + " hour.");

            kitchenBroomSpeed = keyboard.nextLine();

            if (kitchenBroomSpeed.length() < 1) {
                System.out.println("\n*** Value cannot be blank ***");
                continue;
            } else if ("Q".equals(kitchenBroomSpeed.toUpperCase())) {
                return true;
            }
            break;
        }

        while (!done) {

            System.out.println("\nNext enter the amount of time you want to fly in seconds.");

            timeOnBroom = keyboard.nextLine();

            if (timeOnBroom.length() < 1) {
                System.out.println("\n*** Value cannot be blank ***");
                continue;
            } else if ("Q".equals(timeOnBroom.toUpperCase())) {
                return true;
            }
            break;
        }

        kitchenBroomSpeedDouble = Double.parseDouble(kitchenBroomSpeed);
        timeOnBroomDouble = Double.parseDouble(timeOnBroom);

        QuidditchControl quidditchControl = new QuidditchControl();
        quidditchControl.calcKitchenBroomTime(kitchenBroomSpeedDouble, timeOnBroomDouble);

        // return to previous view;
        return true;
    }
}
