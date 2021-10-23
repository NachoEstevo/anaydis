package anaydis.compression;

import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CircularStringTest {

    @Test
    public void test_iterator(){
        CircularString circleString = new CircularString("ABRACADABRA".toCharArray());
        Iterator<Character> iterator = circleString.iterator();
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
        CircularString circleString = new CircularString("ABRACADABRA".toCharArray());
        CircularString shifted = circleString.shift().shift();
        Iterator<Character> iterator = shifted.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        assertEquals("RAABRACADAB", stringBuilder.toString());
    }

    @Test
    public void test_comparator(){
        CircularString circleString = new CircularString("ABRACADABRA".toCharArray());
        CircularString shifted = circleString.shift();
        /*
        ABRACADABRA
        AABRACADABR
         */
        assertTrue(circleString.compareTo(shifted) > 0);

        circleString = new CircularString("ABRACADABRA".toCharArray());
        shifted = circleString.shift().shift();
        /*
        ABRACADABRA
        RAABRACADAB
         */
        assertTrue(circleString.compareTo(shifted) < 0);
    }

    @Test
    public void test_to_String(){
        CircularString circleString = new CircularString("ABRACADABRA".toCharArray());
        CircularString shifted = circleString.shift();
        assertEquals(circleString.toString(), "ABRACADABRA");
        assertEquals(shifted.toString(), "AABRACADABR");

    }

}