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
public class DiagonAlleyControlTest {
    
    public DiagonAlleyControlTest() {
    }

    /**
     * Test of convertUsdToGalleons method, of class DiagonAlleyControl.
     */
    @Test
    public void testConvertUsdToGalleons() {
        System.out.println("\tConvert USD to Galleons");
        
        /*************************
         *  Test Case #1
         *************************/
        System.out.println("\tTest case #1");
        // (dollars + (cents * 0.01)) * 0.735
        // input values for test case 1
        double dollars = 15.0;
        double cents = 89.0;
        
        double expResult = 11.68; // expected output returned value
        
        // create instance of PolyjuiceControl class
        DiagonAlleyControl instance = new DiagonAlleyControl();
        
        // call function to run test
        double result = instance.convertUsdToGalleons(dollars, cents);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.01);
        
        
        /*************************
         *  Test Case #2
         *************************/
        System.out.println("\tTest case #2");
        // (dollars + (cents * 0.01)) * 0.735
        // input values for test case 2
        dollars = 2.0;
        cents = 72.0;
        
        expResult = -1; // expected output returned value
        
        // call function to run test
        result = instance.convertUsdToGalleons(dollars, cents);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0);
        
        
        /*************************
         *  Test Case #3
         *************************/
        System.out.println("\tTest case #3");

        // input values for test case 3
        dollars = 900.0;
        cents = 12.0;
        
        expResult = -2; // expected output returned value
        
        // call function to run test
        result = instance.convertUsdToGalleons(dollars, cents);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0);
        
        
        
        /*************************
         *  Test Case #4
         *************************/
        System.out.println("\tTest case #4");

        // input values for test case 4
        dollars = 375.0;
        cents = 102.0;
        
        expResult = -4; // expected output returned value
        
        // call function to run test
        result = instance.convertUsdToGalleons(dollars, cents);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0);
        
        
        /*************************
         *  Test Case #5
         *************************/
        System.out.println("\tTest case #5");

        // input values for test case 5
        dollars = 50.0;
        cents = 69.0;
        
        expResult = 37.25; // expected output returned value
        
        // call function to run test
        result = instance.convertUsdToGalleons(dollars, cents);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.01);
        
        
        /*************************
         *  Test Case #6
         *************************/
        System.out.println("\tTest case #6");

        // input values for test case 6
        dollars = 123.0;
        cents = 99.0;
        
        expResult = 91.13; // expected output returned value
        
        // call function to run test
        result = instance.convertUsdToGalleons(dollars, cents);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.01);
        
        
        /*************************
         *  Test Case #7
         *************************/
        System.out.println("\tTest case #7");

        // input values for test case 7
        dollars = 5.0;
        cents = 33.0;
        
        expResult = 3.92; // expected output returned value
        
        // call function to run test
        result = instance.convertUsdToGalleons(dollars, cents);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.01);
    }
    
}
