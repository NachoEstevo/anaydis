package anaydis.sort;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class QuickSortersBenchmarksTest {

    @Test
    public void QuickSortersTestComparison() throws IOException {
        QuickSorter quickSorter = new QuickSorter();
        QuickSorterCut quickSorterCut = new QuickSorterCut();
        QuickSorterNonRecursive quickSorterNonRecursive = new QuickSorterNonRecursive();
        QuickMedOfThree quickMedOfThree = new QuickMedOfThree();
        ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort();

        ArrayList<AbstractSorter> sorters = new ArrayList<>();
        sorters.add(quickSorter);
        sorters.add(quickSorterCut);
        sorters.add(quickSorterNonRecursive);
        sorters.add(quickMedOfThree);
        sorters.add(threeWayQuickSort);

        CsvWriter writer = new CsvWriter();
        IntegerDataSetGenerator generator = new IntegerDataSetGenerator();

        ArrayList<Integer> sizes = new ArrayList<>();
        sizes.add(12500);
        sizes.add(25000);
        sizes.add(50000);
        sizes.add(100000);

        for (int size: sizes) {
            for (Sorter aSorter: sorters) {

            ArrayList<Integer> randInts = (ArrayList<Integer>) generator.createRandom(size);

            long startQuick = System.currentTimeMillis();
            aSorter.sort(generator.getComparator(),randInts);
            long endQuick = System.currentTimeMillis();
            long result = endQuick  - startQuick;
            writer.writeForMergeSorts("./QuickSorters-Benchmark.txt",aSorter.getType(),result,size);
            }
        }
    }
}

