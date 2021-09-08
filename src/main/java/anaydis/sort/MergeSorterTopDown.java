package anaydis.sort;

import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.List;

public class MergeSorterTopDown extends AbstractSorter{

    public MergeSorterTopDown(){super(SorterType.MERGE_TOP_DOWN);}

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {mergetopDown(list , 0 , list.size() - 1 , comparator);}

    private <T>void mergetopDown(@NotNull List<T> list, @NotNull int l, @NotNull int r,@NotNull Comparator<T> comparator) {
        if(l < r) {
            int mid = (l + r) / 2;
            mergetopDown(list, l, mid, comparator);
            mergetopDown(list, mid + 1, r, comparator);
            merge(list, l, mid, r, comparator);
        }
    }
}
