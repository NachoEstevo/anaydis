package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickSorterCut extends AbstractSorter {
    InsertionSorter insertion = new InsertionSorter();

    public QuickSorterCut(){super(SorterType.QUICK_CUT);}

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
       quicksort(comparator,list,0,list.size()-1);
       insertion.sort(comparator,list);
    }

    private <T> void quicksort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r){
        if (r-l <= 10) return;
        int i = partition(list, l, r,comparator);
        quicksort(comparator,list, l, i - 1);
        quicksort(comparator,list, i + 1, r);
    }
}
