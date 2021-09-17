package anaydis.search;

import java.util.ArrayList;
import java.util.Iterator;

public class RandTreeIterator<K> implements Iterator<K> {


        private ArrayList<K> keys;
        private int counter;

        public RandTreeIterator(){
            counter=0;
            keys=new ArrayList<K>();
            //inOrder(root,keys);

            System.out.println("KeyIterator()");
            for(K k:keys)
                System.out.print(k+" ");
            System.out.println();

        }

        public boolean hasNext(){
            return counter<keys.size();
        }

        public K next(){
            return keys.get(counter++);
        }

    public Iterator<K> iterator(){
        Iterator<K> seer=new RandTreeIterator<>();

        return seer;
    }

}
