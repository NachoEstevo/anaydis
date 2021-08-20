package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class IntegerDataSetGenerator implements DataSetGenerator<Integer>{
    private List<Integer> integerList;

    public IntegerDataSetGenerator(){
        integerList = new ArrayList<>();
    }
    @Override
    public @NotNull List<Integer> createAscending(int length) {
        List<Integer>  auxList = integerListInit();
        for (int i = 0; i < length; i++) {
            integerList.add(auxList.get(i));
        }
        return integerList;
    }

    @Override
    public @NotNull List<Integer> createDescending(int length) {
        Collections.sort(createRandom(length));
        integerList = reverseArrayList(integerList);
        return integerList;
    }

    @Override
    public @NotNull List<Integer> createRandom(int length) {
        List<Integer>  auxList = integerListInit();
        for (int i = 0; i < length; i++) {
            integerList.add(auxList.get((int) (Math.random()* auxList.size())));
            System.out.println(integerList.size());
        }
        return integerList;
    }

    private List<Integer> reverseArrayList(List<Integer> alist){
        ArrayList<Integer> revArrayList = new ArrayList<>();
        for (int i = alist.size() - 1; i >= 0; i--) {
            revArrayList.add(alist.get(i));
        }
        return revArrayList;
    }

    @Override
    public @NotNull Comparator<Integer> getComparator() {
        return Comparator.naturalOrder();
    }

    private List<Integer> integerListInit() {
        return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53,
                54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100);
    }
}
