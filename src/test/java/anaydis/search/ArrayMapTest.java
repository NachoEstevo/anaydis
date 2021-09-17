package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class ArrayMapTest {

    @Test
    public void arrayMapTest(){
        Comparator<String> comparator = (integer, t1) -> 0;
        ArrayMap<String,Integer> map = new ArrayMap<>(comparator);

        Assert.assertEquals(0,map.size());

       /* map.put("hola",13);
        System.out.println(map.indexOf("hola"));
        System.out.println("keys size: " + map.size());

        map.put("quijote",10);
        System.out.println(map.indexOf("quijote"));
        System.out.println("keys size: " + map.size());

        map.put("burro",20);
        System.out.println(map.indexOf("burro"));
        System.out.println("keys size: " + map.size());

        System.out.println(map.indexOf("pelea"));

        System.out.println(map.get("hola"));
        System.out.println(map.get("burro"));
        System.out.println(map.get("quijote"));


        Assert.assertEquals((Integer)13,map.get("hola"));*/
    }
}
