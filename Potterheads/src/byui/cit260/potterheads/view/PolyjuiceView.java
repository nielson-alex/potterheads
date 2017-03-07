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
public class PolyjuiceView extends View {
    
    public PolyjuiceView(){
        super("D - Calculate and Drink Potion\n"
                + "Q - Back to Menu");
    }
    
    @Override
    public boolean doAction(String choice) {
        switch (choice) {
            case "D":
                this.calculateBrew();
                break;
            case "Q":
                this.quitToMainMenu();
                break;
            default:
                System.out.println("You didn't pick. Pick again.");
                break;
        }
        return false;
    }
    
    private void calculateBrew() {
       Scanner input = new Scanner(System.in);
       System.out.println("You need to decide how much potion to drink:");
       System.out.print("Enter your weight in pounds: ");
       int weight = input.nextInt();
       System.out.print("Enter the amount of time in minutes you want to be disguised: ");
       int time = input.nextInt();
       PolyjuiceControl control = new PolyjuiceControl();
       double ounces = (weight * 2.2)*(time * .00072);
       // #TODO: subtract ounces drank from total amount of ounces
       System.out.println("You feel your skin start to bubble as you drink the potion.");
       
    }
    private void quitToMainMenu() {
        // #TODO: quit to main menu
    }
}
