package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractQuick extends AbstractSorter{
    public List<SorterListener> listeners;

    AbstractQuick(SorterType type){
        super(type);
        listeners = new ArrayList<>();
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {}

    public <T> int partition(List<T> list, int lo, int hi,Comparator<T> comparator) { //Should partition be in another abstract class that extends abstract sorter and is only used in the quick?
        int i = lo - 1;
        int j = hi;
        while(true) {
            while( greater(comparator,list,hi, ++i )) {
                if (i == hi) break;
            }
            while( greater(comparator,list,--j, hi)) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(list, i, j);
        }
        swap(list, i, hi);
        return i;
    }
}
