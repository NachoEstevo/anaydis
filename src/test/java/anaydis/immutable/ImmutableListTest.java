package anaydis.immutable;

import org.junit.Assert;
import org.junit.Test;

public class ImmutableListTest {

    @Test
    public void immutableList(){
       List<Integer> immutable = new Node<>(1, List.cons(2,List.cons(5,List.cons(10,List.cons(21,List.nil())))));

        List<Integer> reversed = immutable.reverse();
        //System.out.println(immutable.size(immutable));
        System.out.println(reversed.head());
        System.out.println(reversed.tail().head());
        System.out.println(reversed.tail().tail().head());
        System.out.println(reversed.tail().tail().tail().head());

        List<Integer> reversedCorrect = new Node<>(21, List.cons(10,List.cons(5,List.cons(2,List.cons(1,List.nil())))));

        //Assert.assertEquals(reversedCorrect.,reversed);

    }
}
