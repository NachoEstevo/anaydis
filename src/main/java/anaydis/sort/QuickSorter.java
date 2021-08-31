package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
/*
public class QuickSorter extends AbstractSorter {

    QuickSorter() {super(SorterType.QUICK);}

    @Override //Basic quicksort implementation. Without optimization
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        if(hi <= lo) return;
        int i = partition(a, lo, hi);
        sort(a, lo, i - 1);
        sort(a, i + 1, hi);
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo - 1;
        int j = hi;
        while(true) {
            while( less(a[++i], a[hi]) ) //find item left to swap
                if (i == hi) break;
            while( less(a[hi], a[--j]) ) //find item right to swap
                if (j == lo) break;
            if (i >= j) break; //check if pointers cross
            swap(a, i, j); //swap
        }
        swap(a, i, hi); //swap with partitioning item
        return i; //return index of item now known to be in place
    }

    @Override
    public void addSorterListener(@NotNull SorterListener listener) {

    }

    @Override
    public void removeSorterListener(@NotNull SorterListener listener) {

    }
}*/
