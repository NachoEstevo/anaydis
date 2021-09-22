package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

public class RWayTrieTest {

    @Test
    public void trieTest(){
        RWayTrieMap<Integer> rWayTrieMap = new RWayTrieMap<>();
        rWayTrieMap.put("quijote",1);
        rWayTrieMap.put("burro",3);
        rWayTrieMap.put("molinos",5);

        Assert.assertEquals((Integer)3,  rWayTrieMap.get("burro"));
    }
}
