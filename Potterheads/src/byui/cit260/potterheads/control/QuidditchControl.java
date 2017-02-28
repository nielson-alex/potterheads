/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class QuidditchControl {

    DecimalFormat df = new DecimalFormat("#.00");

    Scanner inFile;

    public double calcKitchenBroomTime(double kitchenBroomSpeed, double timeOnBroom) {
        //prompt to enter amount of USD to convert to Euros
        System.out.println("\nHow fast do you want to fly? You should know that "
                + "\nthe kitchen broom isn't really meant for flying. That was "
                + "\nput out here by someone as a joke. Regardless, you can "
                + "\nstill choose to fly it. Just keep in mind that it can "
                + "\nonly manage between 10 and 40 miles per hour.");

        // create an input file for the console
        inFile = new Scanner(System.in);

        // read the value of the next double typed into the console
        kitchenBroomSpeed = inFile.nextDouble();

        System.out.println("\nHow long do you want to fly? You have between "
                + "\none and three minutes to catch the Snitch.");

        // create an input file for the console
        timeOnBroom = inFile.nextDouble();

        if (kitchenBroomSpeed < 10) {
            return -1;
        }

        if (kitchenBroomSpeed > 40) {
            return -2;
        }

        if (timeOnBroom < 60) {
            return -3;
        }

        if (timeOnBroom > 360) {
            return -4;
        }

        double snitchSpeed = 50;

        double timeCatchingSnitchWithKitchenBroom = ((timeOnBroom / kitchenBroomSpeed) / 3) * 100;

        System.out.println("\nIt took you " + df.format(timeCatchingSnitchWithKitchenBroom)
                + " seconds to catch the snitch.");

        return timeCatchingSnitchWithKitchenBroom;

        // ((50 / 55) / 3 ) * 100 = 30.3
        // ((50 / 89.9) / 3 ) * 100 = 18.54
    }

    public double calcNimbusTime(double nimbusSpeed, double timeOnBroom) {
//        //prompt to enter amount of USD to convert to Euros
//        System.out.println("\nHow fast do you want to fly? Remember that the "
//                + "\nnimbus is a medium-speed broom. Try to keep it betwen 50 and 90 "
//                + "\nmiles per hour.");
//        
//        // create an input file for the console
//        inFile = new Scanner(System.in);
//        
//        // read the value of the next double typed into the console
//        nimbusSpeed = inFile.nextDouble();
//
//        System.out.println("\nHow long do you want to fly? You have between "
//                + "\none and three minutes to catch the Snitch.");
//
//        // create an input file for the console
//        timeOnBroom = inFile.nextDouble();

        if (nimbusSpeed < 50) {
            return -5;
        }
        if (nimbusSpeed > 90) {
            return -6;
        }
        if (timeOnBroom < 60) {
            return -7;
        }
        if (timeOnBroom > 360) {
            return -8;
        }

        double timeCatchingSnitchWithNimbus = ((timeOnBroom / nimbusSpeed) / 3) * 100;

        System.out.println("\nIt took you " + df.format(timeCatchingSnitchWithNimbus)
                + " seconds to catch the snitch.");

        return timeCatchingSnitchWithNimbus;

    }

    ;
    
    //  ((timeOnBroom/nimbusSpeed) / 3) * 100)
    // ((50/90) / 3) * 100 = 18.52;
    // ((119.9) / 3) * 100 = 13.9
    
    
    public double calcFireboltTime(double fireboltSpeed, double timeOnBroom) {
        //prompt to enter amount of USD to convert to Euros
        System.out.println("\nHow fast do you want to fly? The "
                + "\nfirebolt is the fastest broom they have at Hogwarts. It can "
                + "\nfly anywhere between 100 and 150 "
                + "\nmiles per hour.");

        // create an input file for the console
        inFile = new Scanner(System.in);

        // read the value of the next double typed into the console
        fireboltSpeed = inFile.nextDouble();

        System.out.println("\nHow long do you want to fly? You have between "
                + "\none and three minutes to catch the Snitch.");

        // create an input file for the console
        timeOnBroom = inFile.nextDouble();

        if (fireboltSpeed < 100) {
            return -9;
        }

        if (fireboltSpeed > 150) {
            return -10;
        }

        if (timeOnBroom < 60) {
            return -11;
        }

        if (timeOnBroom > 360) {
            return -12;
        }

        double timeCatchingSnitchWithFirebolt = ((timeOnBroom / fireboltSpeed) / 3) * 100;

        System.out.println("\nIt took you " + df.format(timeCatchingSnitchWithFirebolt)
                + " seconds to catch the snitch.");

        return timeCatchingSnitchWithFirebolt;
    }
;

// ((50/150) / 3) * 100 = 11.11
// ((50/120) / 3) * 100 = 13.89
};
