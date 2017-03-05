/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.util.Scanner;

/**
 *
 * @author Alex
 */

public abstract class View implements ViewInterface {

        protected String displayMessage;

        public View() {
        }

        public View(String message) {
            this.displayMessage = message;
        }

        @Override
        public void display() {
            boolean done = false;
            do {
                String value = this.getInput();
                if (value.toUpperCase().equals("Q")) {
                    return;
                }

                done = this.doAction(value);

            } while (!done);
        }

        @Override
        public String getInput() {
            Scanner keyboard = new Scanner(System.in); // get infile for keyboard 
            boolean valid = false; //value to be returned
            String value = null; // initialize to not valid

            while (!valid) { // loop while an invalid value is entered
                System.out.println("\n" + this.displayMessage);

                value = keyboard.nextLine(); // get next line typed on keyboard
                value = value.trim(); // trim off leading and trailing blanks

                if (value.length() < 1) { //value is blank
                    System.out.println("\n*** You must enter a value ***");
                    continue;
                }

                break; // end the loop
            }

            return value; // return the value entered
        }
        
        @Override
        public boolean doAction(String value) {
            value = value.toUpperCase();
            return false;
        }
    }


