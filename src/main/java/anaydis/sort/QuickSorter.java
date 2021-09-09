package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.List;

public class QuickSorter extends AbstractSorter {

    QuickSorter() {super(SorterType.QUICK);}


    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

        quickSort(list,comparator,0,list.size()-1);
    }


    private <T>void quickSort(List<T> list, Comparator<T> comparator, int lo, int hi){
            if(hi <= lo) return;
            int i = partition(list, lo, hi,comparator);
            quickSort(list,comparator, lo, i - 1);
            quickSort(list,comparator, i + 1, hi);
        }


    @Override
    public void addSorterListener(@NotNull SorterListener listener) {

    }

    @Override
    public void removeSorterListener(@NotNull SorterListener listener) {

    }
}
