package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSorter extends AbstractSorter {

    QuickSorter() {super(SorterType.QUICK);}


    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

        quickSort(list,comparator,0,list.size()-1);
    }
    private <T> int partition(List<T> list, int lo, int hi,Comparator<T> comparator) {
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
