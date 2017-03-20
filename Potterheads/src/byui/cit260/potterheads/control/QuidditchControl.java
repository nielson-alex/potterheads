/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.exceptions.QuidditchControlException;
import static java.lang.Double.NaN;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class QuidditchControl {

    DecimalFormat df = new DecimalFormat("#.00");

    Scanner inFile;

    public double calcKitchenBroomTime(double kitchenBroomSpeed, double timeOnBroom)       
        throws QuidditchControlException {
        
            if (kitchenBroomSpeed < 10) {
                throw new QuidditchControlException("\nRemember, the speed has to be at least 10 miles per hour.");
            }

            if (kitchenBroomSpeed > 40) {
                throw new QuidditchControlException("\nThe kitchen broom's max speed is 40 mph.");
            }

            if (timeOnBroom < 60) {
                throw new QuidditchControlException("\nYou must ride for at least one full minute.");
            }

            if (timeOnBroom > 360) {
                throw new QuidditchControlException("\nYou can't ride for more than three minutes.");
            }

            double snitchSpeed = 50;

            double timeCatchingSnitchWithKitchenBroom = ((timeOnBroom / kitchenBroomSpeed) / 3) * 100;

            System.out.println("\nIt took you " + df.format(timeCatchingSnitchWithKitchenBroom)
                    + " seconds to catch the snitch on the kitchen broom.");

            return timeCatchingSnitchWithKitchenBroom;

        // ((50 / 55) / 3 ) * 100 = 30.3
        // ((50 / 89.9) / 3 ) * 100 = 18.54
    }

    public double calcNimbusTime(double nimbusSpeed, double timeOnBroom) 
        throws QuidditchControlException {

        if (nimbusSpeed < 50) {
            throw new QuidditchControlException("\nThe Nimbus 2000's minimum speed is 50 mph.");
        }
        if (nimbusSpeed > 90) {
            throw new QuidditchControlException("\nThe Nimbus 2000's max speed is 90 mph.");
        }
        if (timeOnBroom < 60) {
            throw new QuidditchControlException("\nYou must ride for at least one full minute.");
        }
        if (timeOnBroom > 360) {
            throw new QuidditchControlException("\nYou can't ride for more than three minutes.");
        }

        double timeCatchingSnitchWithNimbus = ((timeOnBroom / nimbusSpeed) / 3) * 100;

        System.out.println("\nIt took you " + df.format(timeCatchingSnitchWithNimbus)
                + " seconds to catch the snitch on the Nimbus 2000.");

        return timeCatchingSnitchWithNimbus;

    }
    //  ((timeOnBroom/nimbusSpeed) / 3) * 100)
    // ((50/90) / 3) * 100 = 18.52;
    // ((119.9) / 3) * 100 = 13.9

    public double calcFireboltTime(double fireboltSpeed, double timeOnBroom) 
        throws QuidditchControlException {
        if (fireboltSpeed < 100) {
            throw new QuidditchControlException("\nThe Firebolt's minimum speed is 100 mph.");
        }

        if (fireboltSpeed > 150) {
            throw new QuidditchControlException("\nThe Firebolt's max speed is 150 mph.");
        }

        if (timeOnBroom < 60) {
            throw new QuidditchControlException("\nYou must ride for at least one full minute.");
        }

        if (timeOnBroom > 360) {
            throw new QuidditchControlException("\nYou can't ride for more than three minutes.");
        }

        double timeCatchingSnitchWithFirebolt = ((timeOnBroom / fireboltSpeed) / 3) * 100;

        System.out.println("\nIt took you " + df.format(timeCatchingSnitchWithFirebolt)
                + " seconds to catch the snitch on the Firebolt.");

        return timeCatchingSnitchWithFirebolt;
    }
// ((50/150) / 3) * 100 = 11.11
// ((50/120) / 3) * 100 = 13.89
}
