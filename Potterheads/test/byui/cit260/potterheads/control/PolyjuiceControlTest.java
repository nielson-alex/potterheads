/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class PolyjuiceControlTest {
    
    public PolyjuiceControlTest() {
    }

    /**
     * Test of calcTimeTransformed method, of class PolyjuiceControl.
     */
    @Test
    public void testCalcTimeTransformed() {
        System.out.println("calcTimeTransformed");
        
        /*************************
         *  Test Case #1
         *************************/
        System.out.println("\tTest case #1");
        
        // input values for test case 1
        double weight = 180.0;
        double ounces = 3.0;
        
        double expResult = 9.0; // expected output returned value
        
        // create instance of PolyjuiceControl class
        PolyjuiceControl instance = new PolyjuiceControl();
        
        // call function to run test
        double result = instance.calcTimeTransformed(weight, ounces);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #2
         *************************/
        System.out.println("\tTest case #2");
        // input values for test case 1
        weight = 145.0;
        ounces = 10.0;
        
        expResult = -4; // expected output returned value
       
        // call function to run test
        result = instance.calcTimeTransformed(weight, ounces);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #3
         *************************/
        System.out.println("\tTest case #3");
        // input values for test case 1
        weight = 400.0;
        ounces = 2.0;
        
        expResult = -2; // expected output returned value
       
        // call function to run test
        result = instance.calcTimeTransformed(weight, ounces);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #4
         *************************/
        System.out.println("\tTest case #4");
        // input values for test case 1
        weight = 50.0;
        ounces = 0.0;
        
        expResult = -1; // expected output returned value
       
        // call function to run test
        result = instance.calcTimeTransformed(weight, ounces);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        
        /*************************
         *  Test Case #5
         *************************/
        System.out.println("\tTest case #5");
        // input values for test case 1
        weight = 90.0;
        ounces = 4.0;
        
        expResult = 6.0; // expected output returned value
       
        // call function to run test
        result = instance.calcTimeTransformed(weight, ounces);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        
        /*************************
         *  Test Case #6
         *************************/
        System.out.println("\tTest case #6");
        // input values for test case 1
        weight = 300.0;
        ounces = 1.0;
        
        expResult = 5.0; // expected output returned value
       
        // call function to run test
        result = instance.calcTimeTransformed(weight, ounces);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #7
         *************************/
        System.out.println("\tTest case #7");
        // input values for test case 1
        weight = 300.0;
        ounces = 5.0;
        
        expResult = 25.0; // expected output returned value
       
        // call function to run test
        result = instance.calcTimeTransformed(weight, ounces);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
    } 
}
