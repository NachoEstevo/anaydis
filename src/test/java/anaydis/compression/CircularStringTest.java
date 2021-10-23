package anaydis.compression;

import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CircularStringTest {

    @Test
    public void test_iterator(){
        CircularString circularString = new CircularString("ABRACADABRA".toCharArray());
        Iterator<Character> iterator = circularString.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        assertEquals("ABRACADABRA", stringBuilder.toString());
    }

    @Test
    public void test_shift(){
        CircularString circleString = new CircularString("ABRACADABRA".toCharArray());
        CircularString shifted = circleString.shift();
        Iterator<Character> iterator = shifted.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        assertEquals("AABRACADABR", stringBuilder.toString());
    }

    @Test
    public void test_double_Shift(){
        CircularString circularString = new CircularString("ABRACADABRA".toCharArray());
        CircularString shifted = circularString.shift().shift();
        Iterator<Character> iterator = shifted.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        assertEquals("RAABRACADAB", stringBuilder.toString());
    }

    @Test
    public void test_comparator(){
        CircularString circularString = new CircularString("ABRACADABRA".toCharArray());
        CircularString shifted = circularString.shift();
        /*
        ABRACADABRA
        AABRACADABR
         */
        assertTrue(circularString.compareTo(shifted) > 0);

        circularString = new CircularString("ABRACADABRA".toCharArray());
        shifted = circularString.shift().shift();
        /*
        ABRACADABRA
        RAABRACADAB
         */
        assertTrue(circularString.compareTo(shifted) < 0);
    }

    @Test
    public void test_to_String(){
        CircularString circularString = new CircularString("ABRACADABRA".toCharArray());
        CircularString shifted = circularString.shift();
        assertEquals(circularString.toString(), "ABRACADABRA");
        assertEquals(shifted.toString(), "AABRACADABR");

    }

}