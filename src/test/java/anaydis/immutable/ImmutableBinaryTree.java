package anaydis.immutable;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class ImmutableBinaryTree {

    @Test
    public void BinaryTreeTest(){
        Comparator<Integer> cmp = Comparator.naturalOrder();
        BinaryTree<Integer,String> tree = new BinaryTree<>(cmp);

        tree.put(1,"Hola");
        tree.put(2,"Mundo");

        //Assert.assertEquals(tree.get(2),"Mundo");
    }
}
