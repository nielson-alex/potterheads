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
import byui.cit260.potterheads.exceptions.PolyjuiceControlException;
import java.io.PrintWriter;
import potterheads.Potterheads;

public class PolyjuiceView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

    public PolyjuiceView() {
        super("\nEnter your weight in pounds: \n"
                + "(press 'C' to continue or 'Q' to go back");
    }

    @Override
    public boolean doAction(String value) 
        throws NumberFormatException {
        value = value.toUpperCase();
        boolean done = false;
        
        Scanner keyboard = new Scanner(System.in);
        String weight = value;
        String ozOfPotion = ""; //value to be returned
        double weightDouble = 0;
        double ozOfPotionDouble = 0;

        while (!done) {
            if ("Q".equals(weight.toUpperCase())) {
                return true;
            } else {
                try {
                    weightDouble = Double.parseDouble(weight);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number.");
                    return false;
                }
            
            }
            break;
        }

        while (!done) {
            this.console.println("\nNow enter the volume of potion you want to make in ounces:\n");

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
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number.");
                    continue;
                }
            }
            break;
        }

        try {
            this.calcPotionBrewed(weightDouble, ozOfPotionDouble);
        } catch (PolyjuiceControlException ex) {
            this.console.println(ex.getMessage());
        }
        
        return true;
    }
        
    private boolean calcPotionBrewed(double weightDouble, double ozOfPotionDouble) 
        throws PolyjuiceControlException {
        PolyjuiceControl polyjuiceControl = new PolyjuiceControl();
        
        try {
            polyjuiceControl.calcTimeTransformed(weightDouble, ozOfPotionDouble);
        } catch (PolyjuiceControlException ne) {
            this.console.println(ne.getMessage());
        }

        // return to previous view;
        return true;
    }
}
