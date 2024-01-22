package lpa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {
       private Utilities u;
       @Before
       public void setUp() {
           u = new Utilities();
       }
    @Test
    public void everyNthChar() {
        char[] expected = new char[] {'e', 'l'};
        assertArrayEquals(expected, u.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2));
    }    @Test
    public void everyNthChar_nIsGreaterThanLength() {
        char[] tested = u.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 6);
        assertEquals(tested, u.everyNthChar(tested, 6)); // it works cause method returns exactly the same instance
        //or
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, tested);
    }

    @Test
    public void removePairs_AABCDDEFF() {

        assertEquals( "ABCDEF", u.removePairs("AABCDDEFF"));
    }
    @Test
    public void removePairs_ABCCABDEEF() {

        assertEquals( "ABCABDEF", u.removePairs("ABCCABDEEF"));
    }
    @Test
    public void removePairs_null() {

        assertNull( "Did not get null returned, argument passed was null", u.removePairs(null));
    }
    @Test
    public void removePairs_shorterThan2() {
        assertEquals( "A", u.removePairs("A"));
        assertEquals( "", u.removePairs(""));
    }

    @Test
    public void converter() {
        assertEquals(300, u.converter(10, 5));
    }
    @Test(expected = ArithmeticException.class)
    public void converter_divideByZero() {
       u.converter(10, 0);
    }

    @Test
    public void nullIIfOddLength() {
        assertEquals("tata", u.nullIIfOddLength("tata"));
        ///or
        assertNotNull(u.nullIIfOddLength("tata"));
    }
    @Test
    public void nullIIfOddLength_OddString() {
        assertNull("String didn't have length of odd number", u.nullIIfOddLength("tatas"));
    }
}