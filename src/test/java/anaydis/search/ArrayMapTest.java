package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class ArrayMapTest {

    @Test
    public void arrayMapTest(){
        Comparator<Integer> comparator = (integer, t1) -> 0;
        ArrayMap<Integer,Integer> map = new ArrayMap<>(comparator);

        Assert.assertEquals(0,map.size());

        map.put(0,13);
        //System.out.println(map.indexOf(0));
        //System.out.println("keys size: " + map.keys.size());

        map.put(1,10);
        //System.out.println(map.indexOf(1));
        //System.out.println("keys size: " + map.keys.size());

        map.put(5,20);
        //System.out.println(map.indexOf(2));
        //System.out.println("keys size: " + map.keys.size());

        //System.out.println(map.indexOf(5));

        System.out.println(map.get(0));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));

        Assert.assertEquals((Integer)20,map.get(0));
    }
}
