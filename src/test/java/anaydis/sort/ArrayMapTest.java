package anaydis.sort;

import anaydias.search.ArrayMap;
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
        map.put(1,10);
        map.put(5,20);

        //Assert.assertEquals((Integer)10,map.get(1));
    }
}
