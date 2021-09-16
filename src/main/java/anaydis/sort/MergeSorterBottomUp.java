package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class MergeSorterBottomUp extends AbstractMerge{

    public MergeSorterBottomUp(){super(SorterType.MERGE_BOTTOM_UP);}


    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {bottomUp(list, list.size()-1,comparator);}

    private <T>void bottomUp(List<T> list, int high, Comparator<T> comparator){

        for(int middle = 1; middle <= high; middle *= 2) {
            final int middleX2 = middle * 2;
            for (int low1 = 0; low1 <= high - middle; low1 += middleX2) {
                final int high1 = Math.min(low1 + middleX2 - 1, high);
                merge(list, low1, low1 + middle - 1, high1,comparator);
            }
        }
    }
}
