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
        final T aux =  list.set(i,list.get(j));
        list.set(j,aux);
    }

    public  <T> boolean greater(Comparator<T> comparator, List<T> list, int i, int j) {
        return comparator.compare(list.get(i),list.get(j)) > 0;
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
