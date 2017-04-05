/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.io.PrintWriter;
import potterheads.Potterheads;
import java.util.Scanner;

/**
 *
 * @author aleecrook
 */
public class HouseQuizView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();

    public HouseQuizView() {
        super("T - Discover which house you are in.\n"
                + "Q - Back to main menu.\n\n");

    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();

        switch (choice) {
            case "T":
                this.takeQuiz();
                break;
            case "Q":
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "you must enter a value.");
                break;
        }
        return false;
    }

    private void takeQuiz() {
        this.console.println("The great hall is filled with people.\n"
                + "You see an old ratted hat sitting on a stool.\n"
                + "Prepare to be sorted.");

        int gryffindor = 0;
        int slytherin = 0;
        int hufflepuff = 0;
        int ravenclaw = 0;
        String choice;

        Scanner keyboard = new Scanner(System.in);

        this.console.println("Which trait best describes you?\n"
                + "A: Brave\n"
                + "B: Intelligent\n"
                + "C: Kind\n"
                + "D: Cunning");
        choice = keyboard.nextLine();

        if (choice == "A") {
            gryffindor++;
        } else if (choice == "B") {
            ravenclaw++;
        } else if (choice == "C") {
            hufflepuff++;
        } else {
            slytherin++;
        }

        this.console.println("Which animal would you choose for you Hogwarts pet?\n"
                + "A: Rat\n"
                + "B: Toad\n"
                + "C: Owl\n"
                + "D: Cat");

        choice = keyboard.nextLine();

        if (choice == "A") {
            gryffindor++;
        } else if (choice == "B") {
            ravenclaw++;
        } else if (choice == "C") {
            hufflepuff++;
        } else {
            slytherin++;
        }

        this.console.println("Which ghost is your favorite?\n"
                + "A: Nearly-Headless Nick\n"
                + "B: Grey Lady\n"
                + "C: Fat Friar\n"
                + "D: Bloody Baron");
        choice = keyboard.nextLine();

        if (choice == "A") {
            gryffindor++;
        } else if (choice == "B") {
            ravenclaw++;
        } else if (choice == "C") {
            hufflepuff++;
        } else {
            slytherin++;
        }

        this.console.println("Which class would you most like?\n"
                + "A: Potions\n"
                + "B: Charms\n"
                + "C: Defense Against the Dark Arts\n"
                + "D: History of Magic");
        choice = keyboard.nextLine();

        if (choice == "A") {
            gryffindor++;
        } else if (choice == "B") {
            ravenclaw++;
        } else if (choice == "C") {
            hufflepuff++;
        } else {
            slytherin++;
        }

        this.console.println("Which flavor of Bertie Botts Every Flavor Beans would you like most?\n"
                + "A: Chocolate\n"
                + "B: Licorice\n"
                + "C: Strawberry\n"
                + "D: Peanut Butter");
        choice = keyboard.nextLine();

        if (choice == "A") {
            gryffindor++;
        } else if (choice == "B") {
            ravenclaw++;
        } else if (choice == "C") {
            hufflepuff++;
        } else {
            slytherin++;
        }

        if (gryffindor >= slytherin && gryffindor >= ravenclaw) {
            this.console.println("Gryffindor!!!");
        } else if (slytherin > gryffindor && slytherin >= ravenclaw) {
            this.console.println("Slytherin!!!");
        } else if (ravenclaw > gryffindor && ravenclaw > slytherin) {
            this.console.println("Ravenclaw!!!");
        } else {
            this.console.println("Hufflepuff!!!");
        }

    }

}
