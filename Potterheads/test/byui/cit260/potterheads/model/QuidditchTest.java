/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aleecrook
 */
public class QuidditchTest {
    
    public QuidditchTest() {
    }

    /**
     * Test case 1
     */
    @Test
    public void testCalcQuidditch();
        system.out.println("calcQuidditch");
    /**Test case 1*/
       
        system.out.println("\tTest case #1");
        
        
    /**input values for test case 1*/
        double broom = Nimbus;
        double ride = "yes";
        
        double expResults = 15.00;
        
        Quidditch instance = new Quidditch();
        
        double result = instance.calcQuidditch(broom, ride);
        
        assertEquals(expResults, results, 0.0001);
}
