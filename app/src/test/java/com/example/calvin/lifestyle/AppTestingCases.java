package com.example.calvin.lifestyle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AppTestingCases {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void water_addition() throws Exception{
        //test if water count is adding correctly
        assertEquals(10, 2);

    }
    @Test
    public void water_subtraction() throws Exception{
        //test if water count is subtracting correctly
        assertEquals(5, 1);
    }

    @Test
    public void water_notification() throws Exception{
        //test if water reminder notification is working

    }

    @Test
    public void motivation_notification() throws Exception{
        //test if motivation notification is working

    }

    @Test
    public void productivity_notification() throws Exception{
        //test if productivity notification is working

    }

}