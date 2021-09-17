package anaydis.search;

import org.junit.Assert;
import org.junit.Test;
import java.util.Comparator;

public class RandomizedTreeTest {

    @Test
    public void testRandomisedTreeMap(){

        RandomizedTreeMap<Integer , Integer> randomizedTreeMap = new RandomizedTreeMap<Integer , Integer>(Comparator.naturalOrder());
        randomizedTreeMap.put(0 , 1);
        randomizedTreeMap.put(1 , 2);
        randomizedTreeMap.put(2 , 3);


        Assert.assertEquals((Integer) 2, randomizedTreeMap.get(1));
    }
}