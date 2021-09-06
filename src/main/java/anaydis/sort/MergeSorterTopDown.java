package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class MergeSorterTopDown extends AbstractSorter{

    public MergeSorterTopDown(){super(SorterType.MERGE_TOP_DOWN);}

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        mergetopDown(list , 0 , list.size() - 1 , comparator);
    }

    private  <T> void mergetopDown(List<T> list , int low , int high , Comparator<T>  comparator){
        if(low < high) {
            int mid = (low + high) / 2;
            mergetopDown(list, low, mid, comparator);
            mergetopDown(list, mid + 1, high, comparator);
            merge(list, low, mid, high, comparator);
        }
    }
}
