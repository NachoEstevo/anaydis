package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class ThreeWayQuickSort extends AbstractSorter { //Efficient with duplicate keys. Keep the duplicate keys

    public ThreeWayQuickSort() {super(SorterType.QUICK_THREE_PARTITION);}

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

        for (T value : list) {
            System.out.println(value);
        }
        System.out.println("###############");
        threeWay(list, 0, list.size()-1, comparator);
        for (T t : list) {
            System.out.println(t);
        }
        System.out.println("############");
    }


    private <T> void threeWay(List<T> list, int low, int high, Comparator<T> comparator){
        int pivot = partition(list,low,high,comparator);
        int leftEqualKeysCount = 0;
        int rightEqualKeysCount = 0;
        while (true) {
            while (!greater(comparator,list,low,pivot)){
                low++;
            }
            while (greater(comparator,list,high,pivot)) {
                if (high == low)
                    break;
                high--;
            }

            if (low == high && list.get(low).equals(list.get(pivot))) {
                swap(list, low + leftEqualKeysCount, low);
                leftEqualKeysCount++;
                low++;
            }

            if (low >= high) {
                break;
            }

            swap(list, low, high);

            if (list.get(low).equals(list.get(pivot))) {
                swap(list, low + leftEqualKeysCount, low);
                leftEqualKeysCount++;
            }

            if (list.get(high).equals(list.get(pivot))) {
                swap(list, high, high - rightEqualKeysCount);
                rightEqualKeysCount++;
            }
            low++; high--;
        }
    }
    /*private <T> void sort(List<T> list, int low, int high, Comparator<T> comparator) {
        int pivot = partition(list, low, high, comparator);
        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && !greater(list.get(i), list.get(pivot), comparator)) {
                i += 1;
            }
            while (j >= i && greater(list.get(j), list.get(pivot), comparator)) {
                j -= 1;
            }
            if (i < j) {
                list.set(i,list.get(j));
                list.set(j,list.get(i));
            }
        }
        list.set(pivot,list.get(j));
        list.set(j,list.get(pivot));
    }*/
}
