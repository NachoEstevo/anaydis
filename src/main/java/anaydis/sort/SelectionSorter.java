package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class SelectionSorter extends AbstractSorter{

    public SelectionSorter(){
       super(SorterType.SELECTION);
   }

   public  <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

        for (int i = 0; i < list.size(); i++) {
            int min = i;

            for (int j = i+1; j < list.size(); j++) {
                if (greater(comparator, list, min, j)){
                    min = j;
                }
            }
            if (i!=min) {
                swap(list, i, min);
            }
        }
    }
}
