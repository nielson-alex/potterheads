/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */

public abstract class View implements ViewInterface {

    protected String message;
    // week 12 team assignment p. 11

    protected final BufferedReader keyboard = Potterheads.getInFile();
    protected final PrintWriter console = Potterheads.getOutFile();

    public View() {
    }

    public View(String message) {
        this.message = message;
    }

    @Override
    public void display() {
        String value;
        boolean done = false;
        do {
            this.console.println(this.message);
            value = this.getInput();
            done = this.doAction(value);
        } while (!done);
    }

    @Override
    public String getInput() {

        boolean valid = false; //value to be returned
        String value = null; // initialize to not valid

        try {
            while (!valid) { // loop while an invalid value is entered

                value = this.keyboard.readLine(); // get next line typed on keyboard
                value = value.trim(); // trim off leading and trailing blanks

                if (value.length() < 1) { //value is blank
                    ErrorView.display(this.getClass().getName(), "you must enter a value.");
                    continue;
                }

                break; // end the loop
            }
        } catch (Exception e) {
            this.console.println("Error reading input: " + e.getMessage());
        }

        return value; // return the value entered
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        return false;
    }
}
