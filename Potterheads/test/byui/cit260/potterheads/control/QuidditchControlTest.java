/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.control.PolyjuiceControl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class QuidditchControlTest {
    
    public QuidditchControlTest() {
    }
    
    /**
     * Test of calcKitchenBroom method, of class QuidditchControl.
     */
    @Test
    public void testCalcKitchenBroomTime() {
        System.out.println("calcKitchenBroomTime");
        
        /*************************
         *  Test Case #1
         *************************/
        System.out.println("\tTest case #1");
        
        // input values for test case 1
        double kitchenBroomSpeed = 17.0;
        double timeOnBroom = 320.0;
        
        double expResult = 627.5; // expected output returned value
        
        // create instance of PolyjuiceControl class
        QuidditchControl instance = new QuidditchControl();
        
        // call function to run test
        double result = instance.calcKitchenBroomTime(kitchenBroomSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #2
         *************************/
        System.out.println("\tTest case #2");
        // input values for test case 2
        kitchenBroomSpeed = 15.0;
        timeOnBroom = 390.0;
        
        expResult = -4; // expected output returned value
       
        // call function to run test
        result = instance.calcKitchenBroomTime(kitchenBroomSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #3
         *************************/
        System.out.println("\tTest case #3");
        // input values for test case 3
        kitchenBroomSpeed = 5.0;
        timeOnBroom = 170.0;
        
        expResult = -1; // expected output returned value
       
        // call function to run test
        result = instance.calcKitchenBroomTime(kitchenBroomSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #4
         *************************/
        System.out.println("\tTest case #4");
        // input values for test case 4
        kitchenBroomSpeed = 92.0;
        timeOnBroom = 125.0;
        
        expResult = -2; // expected output returned value
       
        // call function to run test
        result = instance.calcKitchenBroomTime(kitchenBroomSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #5
         *************************/
        System.out.println("\tTest case #5");
        // input values for test case 5
        kitchenBroomSpeed = 10.0;
        timeOnBroom = 60.0;
        
        expResult = 200.0; // expected output returned value
       
        // call function to run test
        result = instance.calcKitchenBroomTime(kitchenBroomSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #6
         *************************/
        System.out.println("\tTest case #6");
        // input values for test case 6
        kitchenBroomSpeed = 40.0;
        timeOnBroom = 360.0;
        
        expResult = 300.0; // expected output returned value
       
        // call function to run test
        result = instance.calcKitchenBroomTime(kitchenBroomSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #7
         *************************/
        System.out.println("\tTest case #7");
        // input values for test case 7
        kitchenBroomSpeed = 10.0;
        timeOnBroom = 360.0;
        
        expResult = 1200.0; // expected output returned value
       
        // call function to run test
        result = instance.calcKitchenBroomTime(kitchenBroomSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
    }
    

    
    
    /**
     * Test of calcNimbusTime method, of class QuidditchControl.
     */
    @Test
    public void testCalcNimbusTime() {
        System.out.println("calcNimbusTime");
        
        /*************************
         *  Test Case #1
         *************************/
        System.out.println("\tTest case #1");
        
        // input values for test case 1
        double nimbusSpeed = 85.0;
        double timeOnBroom = 110.0;
        
        double expResult = 43.1; // expected output returned value
        
        // create instance of PolyjuiceControl class
        QuidditchControl instance = new QuidditchControl();
        
        // call function to run test
        double result = instance.calcNimbusTime(nimbusSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #2
         *************************/
        System.out.println("\tTest case #2");
        // input values for test case 2
        nimbusSpeed = 65.0;
        timeOnBroom = 600.0;
        
        expResult = -8; // expected output returned value
       
        // call function to run test
        result = instance.calcNimbusTime(nimbusSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #3
         *************************/
        System.out.println("\tTest case #3");
        // input values for test case 3
        nimbusSpeed = 42.0;
        timeOnBroom = 340.0;
        
        expResult = -5; // expected output returned value
       
        // call function to run test
        result = instance.calcNimbusTime(nimbusSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
    
        
        /*************************
         *  Test Case #4
         *************************/
        System.out.println("\tTest case #4");
        // input values for test case 4
        nimbusSpeed = 107.0;
        timeOnBroom = 53.0;
        
        expResult = -6; // expected output returned value
       
        // call function to run test
        result = instance.calcNimbusTime(nimbusSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #5
         *************************/
        System.out.println("\tTest case #5");
        // input values for test case 5
        nimbusSpeed = 50.0;
        timeOnBroom = 60.0;
        
        expResult = 40.0; // expected output returned value
       
        // call function to run test
        result = instance.calcNimbusTime(nimbusSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #6
         *************************/
        System.out.println("\tTest case #6");
        // input values for test case 6
        nimbusSpeed = 90.0;
        timeOnBroom = 60.0;
        
        expResult = 22.2; // expected output returned value
       
        // call function to run test
        result = instance.calcNimbusTime(nimbusSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #7
         *************************/
        System.out.println("\tTest case #7");
        // input values for test case 7
        nimbusSpeed = 50.0;
        timeOnBroom = 360.0;
        
        expResult = 240.0; // expected output returned value
       
        // call function to run test
        result = instance.calcNimbusTime(nimbusSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
    } 

    
    /**
     * Test of calcFireboltTime of class QuidditchControl.
     */
    @Test
    public void testCalcFireboltTime() {
        System.out.println("calcFireboltTime");
        
        /*************************
         *  Test Case #1
         *************************/
        System.out.println("\tTest case #1");
        
        // input values for test case 1
        double fireboltSpeed = 145.0;
        double timeOnBroom = 320.0;
        
        double expResult = 73.6; // expected output returned value
        
        // create instance of PolyjuiceControl class
        QuidditchControl instance = new QuidditchControl();
        
        // call function to run test
        double result = instance.calcFireboltTime(fireboltSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #2
         *************************/
        System.out.println("\tTest case #2");
        // input values for test case 2
        fireboltSpeed = 150.0;
        timeOnBroom = 500.0;
        
        expResult = -12; // expected output returned value
       
        // call function to run test
        result = instance.calcFireboltTime(fireboltSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #3
         *************************/
        System.out.println("\tTest case #3");
        // input values for test case 3
        fireboltSpeed = 22.0;
        timeOnBroom = 298.2;
        
        expResult = -9; // expected output returned value
       
        // call function to run test
        result = instance.calcFireboltTime(fireboltSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #4
         *************************/
        System.out.println("\tTest case #4");
        // input values for test case 4
        fireboltSpeed = 22000.0;
        timeOnBroom = 172.0;
        
        expResult = -10; // expected output returned value
       
        // call function to run test
        result = instance.calcFireboltTime(fireboltSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0);
        
        
        /*************************
         *  Test Case #5
         *************************/
        System.out.println("\tTest case #5");
        // input values for test case 5
        fireboltSpeed = 150.0;
        timeOnBroom = 60.0;
        
        expResult = 13.3; // expected output returned value
       
        // call function to run test
        result = instance.calcFireboltTime(fireboltSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #6
         *************************/
        System.out.println("\tTest case #6");
        // input values for test case 6
        fireboltSpeed = 100.0;
        timeOnBroom = 360.0;
        
        expResult = 120.0; // expected output returned value
       
        // call function to run test
        result = instance.calcFireboltTime(fireboltSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
        
        
        /*************************
         *  Test Case #7
         *************************/
        System.out.println("\tTest case #7");
        // input values for test case 7
        fireboltSpeed = 100.0;
        timeOnBroom = 60.0;
        
        expResult = 20.0; // expected output returned value
       
        // call function to run test
        result = instance.calcFireboltTime(fireboltSpeed, timeOnBroom);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.1);
    }
}
