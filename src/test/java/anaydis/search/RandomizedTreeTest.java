package anaydis.search;

import org.junit.Assert;
import org.junit.Test;
import java.util.Comparator;

public class RandomizedTreeTest {

    @Test
    public void testRandomisedTreeMap(){

        RandomizedTreeMap<String , Integer> randomizedTreeMap = new RandomizedTreeMap<String , Integer>(Comparator.naturalOrder());
        randomizedTreeMap.put("quijote" , 11);
        randomizedTreeMap.put("hola" , 26);
        randomizedTreeMap.put("burro" , 73);
        randomizedTreeMap.put("chancho" , 11);
        randomizedTreeMap.put("ojota" , 26);
        randomizedTreeMap.put("manteca" , 73);


        Assert.assertEquals((Integer) 73, randomizedTreeMap.get("burro"));
    }
}