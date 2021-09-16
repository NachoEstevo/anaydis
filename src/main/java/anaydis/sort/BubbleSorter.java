package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class BubbleSorter extends AbstractSorter{

    public BubbleSorter() {super(SorterType.BUBBLE);}

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

        boolean lastSwap;
        for (int i = 0; i < list.size() -1; i++) {
            lastSwap = false;
            for (int j = list.size() - 1; j > i; j--) {
                if (greater(comparator, list, j-1, j)) {
                    swap(list, j, j - 1);
                    lastSwap = true;
                }
            }
            if (!lastSwap){ //Optimization
                break;
            }
        }
    }
}



