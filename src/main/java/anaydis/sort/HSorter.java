package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class HSorter extends AbstractSorter {

    public HSorter() {
        super(SorterType.H);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

        sort(comparator, list, 1);//I use 1 to be used later in the ShellSorter
    }

    <T> void sort(Comparator<T> comparator, List<T> list, int i) {

        int h = 4;
        for (i = h; i <= list.size()-1; i++) {
            T data = list.get(i);
            int j = i;
            while (j >= h && greater(list.get(j-h),data, comparator)) {
                list.set(j, list.get(j - h));
                j -= h;
            }
            list.set(j, data);
        }

    }
}

