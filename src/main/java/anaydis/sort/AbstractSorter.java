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
    public List<SorterListener> listeners;
    private final SorterType type;

    AbstractSorter(SorterType type){
        this.type = type;
        listeners = new ArrayList<>();
    }

    public  <T> void swap(List<T> list, int i, int j) {
        for (SorterListener listener: listeners) {
            listener.swap(i,j);
        }
        list.set(j,list.set(i,list.get(j)));
    }
    public <T>void compExch(List<T> a, int i, int j, Comparator<T> comp) {
        if (greater(a.get(i), a.get(j) , comp))
            swap(a, i, j);
    }

    public  <T> boolean greater(Comparator<T> comparator, List<T> list, int i, int j) {
        if (list.get(i).equals(list.get(j))){
            for (SorterListener listener : listeners){
                listener.equals(i,i-2);
            }
        }
        for (SorterListener listener : listeners) {
            listener.greater(i,i-3);
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

    public <T>boolean equals(T obj1, T obj2, Comparator<T> comparator){return comparator.compare(obj1,obj2) == 0;}

    @Override public void addSorterListener(@NotNull final SorterListener listener) {listeners.add(listener);}

    @Override public void removeSorterListener(@NotNull final SorterListener listener) {listeners.remove(listener);}

    @Override public final @NotNull SorterType getType(){
        return type;
    }
}
