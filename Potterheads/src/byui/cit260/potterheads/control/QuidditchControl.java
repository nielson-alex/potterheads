/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

/**
 *
 * @author Alex
 */
public class QuidditchControl {
    public double calcKitchenBroomTime(double kitchenBroomSpeed, double timeOnBroom) {
        // ((360 / 10) / 3) * 100 = 1200
        // ((360 / 40) / 3) * 100 = 300
        // ((60 / 10) / 3) * 100 = 200
        // ((60 / 10) / 3) * 100 = 600
        
        // ((360 / 50) / 3) * 100 = 240
        // ((360 / 90) / 3) * 100 = 133
        // ((60 / 50) / 3) * 100 = 40
        // ((60 / 90) / 3) * 100 = 22
        
        // ((360 / 100) / 3) * 100 = 120
        // ((360 / 150) / 3) * 100 = 80
        // ((60 / 100) / 3) * 100 = 20
        // ((60 / 150) / 3) * 100 = 13.3
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
        return timeCatchingSnitchWithKitchenBroom;
        
    // ((50 / 55) / 3 ) * 100 = 30.3
    // ((50 / 89.9) / 3 ) * 100 = 18.54
    }
    
    public double calcNimbusTime(double nimbusSpeed, double timeOnBroom) {
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
        
        double snitchSpeed = 50;
        
        double timeCatchingSnitchWithNimbus = ((timeOnBroom / nimbusSpeed) / 3) * 100;
        return timeCatchingSnitchWithNimbus;
    };
    
    //  ((timeOnBroom/nimbusSpeed) / 3) * 100)
    // ((50/90) / 3) * 100 = 18.52;
    // ((119.9) / 3) * 100 = 13.9
    
    
    public double calcFireboltTime(double fireboltSpeed, double timeOnBroom) {
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
        
        double snitchSpeed = 50;
        
        double timeCatchingSnitchWithFirebolt = ((timeOnBroom / fireboltSpeed) / 3) * 100;
        return timeCatchingSnitchWithFirebolt;
    };
    
    // ((50/150) / 3) * 100 = 11.11
    // ((50/120) / 3) * 100 = 13.89
    };

