package anaydis.sort;

import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.List;

public class MergeSorterTopDown extends AbstractMerge{

    public MergeSorterTopDown(){super(SorterType.MERGE_TOP_DOWN);}

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        mergeTopDown(list , 0 , list.size() - 1 , comparator);}

    private <T>void mergeTopDown(@NotNull List<T> list, int l, int r,@NotNull Comparator<T> comparator) {
        if(l < r) {
            int mid = (l + r) / 2;
            mergeTopDown(list, l, mid, comparator);
            mergeTopDown(list, mid + 1, r, comparator);
            merge(list, l, mid, r, comparator);
        }
    }
}
