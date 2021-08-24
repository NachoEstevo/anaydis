package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */
abstract class AbstractSorter implements Sorter {
    private final SorterType type;

    AbstractSorter(SorterType type){
        this.type = type;
    }

    public  <T> void swap(List<T> list, int i, int j) {
        final T aux =  list.set(i,list.get(j));
        list.set(j,aux);
    }

    public  <T> boolean greater(Comparator<T> comparator, List<T> list, int i, int j) {
        return comparator.compare(list.get(i),list.get(j)) > 0;
    }

    @Override
    public final @NotNull SorterType getType(){
        return type;
    }
}
