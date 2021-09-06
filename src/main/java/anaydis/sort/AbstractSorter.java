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
    public <T> int partition(List<T> list, int lo, int hi,Comparator<T> comparator) {
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
   public <T>List<T> merge(List<T> listA, List<T> listB,Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        for (int i = 0, j = 0, k = 0; k < listA.size() + listB.size(); k++) {
            if(i >= listA.size()) {
                result.set(i,listB.get(i++));
            }
            else if (j >= listB.size()) {
                result.set(i,listA.get(j++));
            }
            else {
                result.set(i,greater(listA.get(i),listB.get(j),comparator)? listA.get(i++) : listB.get(j++));
            }
        }
        listA = result;
       return listA;
    }

    public <T> void merge(List<T> list , int low , int middle, int high , Comparator<T> comparator){
        int n1 = middle - low + 1;
        int n2 = high - middle;

        List<T> leftList = new ArrayList<>();
        List<T> rightList = new ArrayList<>();

        for (int i = 0; i < n1 ; i++) {
            leftList.add(i , list.get(low + 1));
        }
        for (int j = 0; j < n2 ; j++) {
            rightList.add(j , list.get(middle + j + 1));
        }

        int i = 0, j = 0;

        int k = low;

        while ( i < n1 && j < n2){
            if (greater(rightList.get(j) , leftList.get(i) , comparator)){
                list.set(k , leftList.get(i));
                i++;
            }else {
                list.set(k , rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1){
            list.set(k , leftList.get(i));
            i++;
            k++;
        }

        while (j < n2){
            list.set(k , rightList.get(j));
            j++;
            k++;
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
