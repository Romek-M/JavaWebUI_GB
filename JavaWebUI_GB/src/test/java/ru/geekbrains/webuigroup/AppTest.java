package ru.geekbrains.webuigroup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testSum(){
        int a = 3;
        int b = 2;
        int expected = 5;
        int result = App.sum(a, b);

        assertEquals(expected, result);

    }

    @Test
    public void testDiv(){
        int a = 10;
        int b = 5;
        int expected = 2;
        int result = App.simpleDiv(a, b);

        assertEquals(expected, result);
    }


}
