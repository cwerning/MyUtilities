/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.advjava.jgl.datetime;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author L115student
 */
public class DateUtilitiesTest {

    private DateUtilities instance;

    public DateUtilitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        // Insead of initializing in each test, just do it here
        // Declaration is above.
        instance = new DateUtilities();
    }

    @After
    public void tearDown() {
        // clean up after yourself!
        instance = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void toStringDateNullShouldThrowException() {
        DateUtilities du = new DateUtilities();
        du.toString(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toStringWithPatterDateNullShouldThrowException() {
        DateUtilities du = new DateUtilities();
        du.toString(null, "yyyy/MM/dd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void toStringWithPatternPatternNullShouldThrowException() {
        DateUtilities du = new DateUtilities();
        LocalDateTime ldt = LocalDateTime.now();
        du.toString(ldt, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void toStringWithPatternPatternEmptyShouldThrowException() {
        DateUtilities du = new DateUtilities();
        LocalDateTime ldt = LocalDateTime.now();
        du.toString(ldt, "");
    }

}
