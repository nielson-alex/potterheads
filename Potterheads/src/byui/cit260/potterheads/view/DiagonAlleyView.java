/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;
import java.util.Scanner;
import byui.cit260.potterheads.control.DiagonAlleyControl;
/**
 *
 * @author aleecrook
 */
public class DiagonAlleyView {
    private String menu;
    
    public DiagonAlleyView() {
        this.menu = "Select which location you would like to visit:\n\n"
                + "A: The Leaky Cauldron\n"
                + "B: Gringotts\n"
                + "C: Ollivanders\n"
                + "D: Knockturn Alley\n"
                + "E: Flourish and Blotts\n"
                + "Q: Back to Main Menu";
    }
    
    private void printView() {
        System.out.println(this.getMenu());
    }
    
    public void displayView() {
        boolean error = true;
        while (error) {
            error = false;
            this.printView();
            error = this.doAction(this.getChoice());
        }   
    }
    
    private String getChoice() {
       Scanner input = new Scanner(System.in);
       System.out.print("Choice: ");
       String choice = input.nextLine();
       choice = choice.toUpperCase();
       return choice;
    }
    
    private boolean doAction(String choice) {
       
        switch (choice) {
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
                break;
            default:
                //Invalid Choice
                System.out.println("That is not an option. Pick again.");
                return true;
        }
        
        return false;
        
    }
    
    private void leakyCauldron() {
        System.out.println("The aroma of Butterbeer fills your nostrils. You are in the Leaky Cauldron.");
    }
    
    private void gringotts() {
        
        System.out.println("You hear coins clinking. You are in Gringotts.");
        boolean error = true;
        while (error) {
            error = false;
        
            System.out.println("A: Exchange Money\n"
                    + "Q: Exit Gringotts");

            String choice = this.getChoice();
            if (choice.toUpperCase().equals("A")) {
                //get conversion values
                this.gringottsConversion();
            } else if (choice.toUpperCase().equals("Q")) {
                //Back to menu
                System.out.println("Thanks for visiting Gringotts.");
            } else {
                error = true;
                System.out.println("That is not an option. Pick again.");
            }
            
        }
      
    }
    
    private void gringottsConversion() {
        DiagonAlleyControl control = new DiagonAlleyControl();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of dollars(ex. 5): ");
        double dollars = input.nextDouble();
        System.out.print("Enter the number of cents(ex. 0.50): ");
        double cents = input.nextDouble();
        System.out.println(control.convertUsdToGalleons(dollars, cents));
    }
    
    private void ollivanders() {
        System.out.println("The room is filled with boxes of wands. You are in Ollivanders.");
    }
    
    private void knockturnAlley() {
        System.out.println("You are surrounded by dark, dusty shops. You are in Knockturn Alley.");
    }
    
    private void flourishBlotts() {
        System.out.println("Books are stacked around the room. You are in Flourish and Blotts.");
    }
    
    private String getMenu() {
        return this.menu;
    }
}
