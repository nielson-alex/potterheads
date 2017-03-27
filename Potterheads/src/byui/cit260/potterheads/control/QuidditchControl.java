/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.exceptions.QuidditchControlException;
import byui.cit260.potterheads.model.Spell;
import java.io.PrintWriter;
import static java.lang.Double.NaN;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class QuidditchControl {
    protected final PrintWriter console = Potterheads.getOutFile();

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

        this.console.println("\nIt took you " + df.format(timeCatchingSnitchWithKitchenBroom)
                + " seconds to catch the snitch on the kitchen broom.");
        
        
        Spell expelliarmus = new Spell(Spell.SpellType.expelliarmus);
        
        if (timeCatchingSnitchWithKitchenBroom >= 200 && timeCatchingSnitchWithKitchenBroom <= 300 ) {
            if ((Potterheads.getPlayer().getSpells()).contains(expelliarmus)) {
                this.console.println("\nYou've already learned expelliarmus, but good job\n"
                        + "catching the snitch!");
            } else { 
                Potterheads.getPlayer().getSpells().add(expelliarmus);
                this.console.println("\nCongratulations! For catching the snitch in in under " + 
                        df.format(timeCatchingSnitchWithKitchenBroom) + " seconds, Cedric Diggery decided\n"
                                + "to teach you expelliarmus!");
            }
        } else {
            this.console.println("\nYou caught the snitch in " + df.format(timeCatchingSnitchWithKitchenBroom) + 
                    "seconds. That's a good time, but not quite what Cedric was looking for. Try again!");
        }
    
        
        
        return timeCatchingSnitchWithKitchenBroom;
        // minimum speed = 10
        // maximum speed = 60
        // minimum time = 60
        // maximum time = 60
        // equation: ((time on broom / speed) / 3 ) * 100 = timeToCatchSnitch
        // minimum ranges
        //      ((60 / 10) / 3 ) * 100 = 200.0
        // maximum ranges 
        //      ((360 / 40) / 3 ) * 100 = 300.0
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
        
        Spell expelliarmus = new Spell(Spell.SpellType.expelliarmus);
        
        this.console.println("\nIt took you " + df.format(timeCatchingSnitchWithNimbus)
                + " seconds to catch the snitch on the Nimbus 2000.");
        
        if (timeCatchingSnitchWithNimbus >= 75 && timeCatchingSnitchWithNimbus <= 115 ) {
            if ((Potterheads.getPlayer().getSpells()).contains(expelliarmus)) {
                this.console.println("\nYou've already learned expelliarmus, but good job\n"
                        + "catching the snitch!");
            } else { 
                Potterheads.getPlayer().getSpells().add(expelliarmus);
                this.console.println("\nCongratulations! For catching the snitch in in under " + 
                        df.format(timeCatchingSnitchWithNimbus) + " seconds, Cedric Diggery decided\n"
                                + "to teach you expelliarmus!");
            }
        } else {
            this.console.println("\nYou caught the snitch in " + df.format(timeCatchingSnitchWithNimbus) + 
                    "seconds. That's a good time, but not quite what Cedric was looking for. Try again!");
        }

        return timeCatchingSnitchWithNimbus;

    }
    //  ((timeOnBroom/nimbusSpeed) / 3) * 100)
    // minimum speed = 50
    // maximum speed = 90
    // minimum time = 60
    // maximum time = 360
    // equation: ((time on broom / speed) / 3 ) * 100 = timeToCatchSnitch
    // minimum ranges
    //      ((60 / 50) / 3 ) * 100 = 40.0
    // maximum ranges 
    //      ((360 / 90) / 3 ) * 100 = 133.33

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

        this.console.println("\nIt took you " + df.format(timeCatchingSnitchWithFirebolt)
                + " seconds to catch the snitch on the Firebolt.");
        
        Spell expelliarmus = new Spell(Spell.SpellType.expelliarmus);

        if (timeCatchingSnitchWithFirebolt >= 75 && timeCatchingSnitchWithFirebolt <= 115 ) {
            if ((Potterheads.getPlayer().getSpells()).contains(expelliarmus)) {
                this.console.println("\nYou've already learned expelliarmus, but good job\n"
                        + "catching the snitch!");
            } else { 
                Potterheads.getPlayer().getSpells().add(expelliarmus);
                this.console.println("\nCongratulations! For catching the snitch in in under " + 
                        df.format(timeCatchingSnitchWithFirebolt) + " seconds, Cedric Diggery decided\n"
                                + "to teach you expelliarmus!");
            }
        } else {
            this.console.println("\nYou caught the snitch in " + df.format(timeCatchingSnitchWithFirebolt) + 
                    "seconds. That's a good time, but not quite what Cedric was looking for. Try again!");
        }
        
        return timeCatchingSnitchWithFirebolt;
    }
    // minimum speed = 100
    // maximum speed = 150
    // minimum time = 60
    // maximum time = 360
    // equation: ((time on broom / speed) / 3 ) * 100 = timeToCatchSnitch
    // minimum ranges
    //      ((60 / 100) / 3 ) * 100 = 20.0
    // maximum ranges 
    //      ((360 / 150) / 3 ) * 100 = 80.0
}
