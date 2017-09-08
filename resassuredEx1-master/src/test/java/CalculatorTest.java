/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calc.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pravien
 */
public class CalculatorTest
{
    Calculator cal ;
    public CalculatorTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @Before
    public void setUp()
    {
        cal = new Calculator();
    }
    
    @After
    public void tearDown()
    {
    }

    
     @Test
     public void testCalc() {
     int add = cal.add(1, -1);
     int mul = cal.mul(1, -1);
     int sub = cal.sub(1, -1);
     int div = cal.div(1, -1);
     int div0 = cal.div(1, 1);
     assertEquals(add, 0);
     assertEquals(mul, -1);
     assertEquals(sub, 2);
     assertEquals(div, -1);
     
     }
}
