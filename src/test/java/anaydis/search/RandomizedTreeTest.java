package anaydis.search;

import org.junit.Assert;
import org.junit.Test;
import java.util.Comparator;

public class RandomizedTreeTest {

    @Test
    public void testRandomisedTreeMap(){

        RandomizedTreeMap<String , Integer> randomizedTreeMap = new RandomizedTreeMap<String , Integer>(Comparator.naturalOrder());
        System.out.println(randomizedTreeMap.put("A" , 1));
        //randomizedTreeMap.put("B" , 2);
        //randomizedTreeMap.put("C" , 3);

        //Assert.assertEquals((Integer) 2, randomizedTreeMap.get("B"));
    }
}