/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import java.io.PrintWriter;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class ErrorView {

    private static final PrintWriter ERRORFILE = Potterheads.getOutFile();
    private static final PrintWriter LOGFILE = Potterheads.getLogFile();

    public static void display(String className, String errorMessage) {
        ERRORFILE.println(
                "--------------------------------------------------------------"
                + "\n- Error = " + errorMessage
                + "\n-------------------------------------------------------------");

        // log error
        LOGFILE.println(className + " - " + errorMessage);
    }
}
