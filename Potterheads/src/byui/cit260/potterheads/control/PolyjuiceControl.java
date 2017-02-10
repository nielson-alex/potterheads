/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

/**
 *
 * @author alex
 */
public class PolyjuiceControl {
    
    public double calcTimeTransformed(double weight, double ounces) {
        
        if (weight < 90) {
            return -1;
        }
        
        if (weight > 300) {
            return -2;
        }
        
        if (ounces < 1) {
            return -3;
        }
        
        if (ounces > 5) {
            return -4;
        }
        
        double timeTransformed = (ounces * weight) / 60;
        return timeTransformed;
        
    }
}
