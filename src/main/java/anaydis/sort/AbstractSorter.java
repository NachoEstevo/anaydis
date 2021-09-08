package anaydis.sort;

import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */
abstract class AbstractSorter implements ObservableSorter {
    public ArrayList<ListenerImpl> listeners;
    private final SorterType type;

    AbstractSorter(SorterType type){
        this.type = type;
        listeners = new ArrayList<>();
    }

    public  <T> void swap(List<T> list, int i, int j) {
        for (ListenerImpl listener: listeners) {
            listener.swap(i,j);
        }
        final T aux =  list.set(i,list.get(j));
        list.set(j,aux);
    }
    public <T>void compExch(List<T> a, int i, int j, Comparator<T> comp) {
        if (greater(a.get(i), a.get(j) , comp))
            swap(a, i, j);
    }

    public  <T> boolean greater(Comparator<T> comparator, List<T> list, int i, int j) {
        if (list.get(i).equals(list.get(j))){
            for (int k = 0; i< listeners.size(); k++){
                listeners.get(i).equals(i,i-2);
            }
        }
        for (int k = 0; i < listeners.size(); k++) {
            listeners.get(i).greater(i,i-3);
        }
        return comparator.compare(list.get(i),list.get(j)) > 0;
    }
    public <T> boolean greater(T item1, T item2,Comparator<T> comparator){
        if (item1.equals(item2)){
            for (int i = 0; i< listeners.size(); i++){
                listeners.get(i).equals(i,i-2);
            }
        }
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).greater(i,i-3);
        }
        return comparator.compare(item1,item2) >0;
    }
    public <T> int partition(List<T> list, int lo, int hi,Comparator<T> comparator) { //Should partition be in another abstract class that extends abstract sorter and is only used in the quicks?
        int i = lo - 1;
        int j = hi;
        while(true) {
            while( greater(comparator,list,hi, ++i )) { //find item left to swap
                if (i == hi) break;
            }
            while( greater(comparator,list,--j, hi)) { //find item right to swap
                if (j == lo) break;
            }
            if (i >= j) break; //check if pointers cross
            swap(list, i, j); //swap
        }
        swap(list, i, hi); //swap with partitioning item
        return i; //return index of item now known to be in place
    }
    /*
    public <T>Node<T> merge(Node<T> a, Node<T> b) {
        Node<T> c, result = new Node<>();
        for(result = c; a != null && b != null; c = c.next) {
            if (a.value < b.value) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }
        }
        c.next = a == null ? b : a;
        return result.next;
    }*/

    public <T>boolean equals(T obj1, T obj2, Comparator<T> comparator){return comparator.compare(obj1,obj2) == 0;}

    public <T> void merge(List<T> list , int low , int middle, int high , Comparator<T> comparator){
        int l2 = middle +1;

        if (greater(list.get(l2) , list.get(middle) , comparator)){
            return;
        }

        while (low <= middle && l2 <= high){

            if (greater( list.get(l2), list.get(low),  comparator)){
                low++;
            }else{
                T v = list.get(l2);
                int index = l2;

                while (index != low){
                    list.set(index , list.get(index-1));
                    index--;
                }
                list.set(low , v);

                low++;
                middle++;
                l2++;
            }
        }
    }

    @Override
    public void addSorterListener(@NotNull final SorterListener listener) {
        listeners.add((ListenerImpl) listener);
    }

    @Override
    public void removeSorterListener(@NotNull final SorterListener listener) {
        listeners.remove((ListenerImpl) listener);
    }

    @Override
    public final @NotNull SorterType getType(){
        return type;
    }
}
