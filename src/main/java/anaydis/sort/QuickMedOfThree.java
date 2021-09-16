package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickMedOfThree extends AbstractQuick{
    private final InsertionSorter insertionSorter;
    public QuickMedOfThree() {
        super(SorterType.QUICK_MED_OF_THREE);
        insertionSorter = new InsertionSorter();
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        quicksort(list , 0 , list.size() -1 , comparator);
        insertionSorter.sort(comparator , list);
    }

    public <T> void quicksort (List<T> list , int lo , int hi , Comparator<T> comparator ){
        int m = 10;
        if (hi - lo <= m) return;
        swap(list , (lo + hi) / 2 , hi -1);
        compExch(list , lo , hi-1, comparator);
        compExch(list , lo , hi , comparator);
        compExch(list , hi -1 , hi , comparator);
        int i = partition(list , lo+1 , hi - 1, comparator);
        quicksort(list, lo, i-1, comparator);
        quicksort(list, i+1, hi , comparator);
    }

    @Override
    public void addSorterListener(@NotNull SorterListener listener) {
        listeners.add( listener);
        insertionSorter.addSorterListener(listener);
    }

    @Override
    public void removeSorterListener(@NotNull SorterListener listener) {
        listeners.add( listener);
        insertionSorter.removeSorterListener(listener);
    }
}
