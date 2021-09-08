package anaydis.sort;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class QuikcSortMTest {
    /**This class is in charged of determining the best M for improving the times in Quicksort with Cut*/


    @Test
    public void CutQuickSortMFinding() throws IOException {
        QuickSorterCut quickSorterCut = new QuickSorterCut();
        IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        CsvWriter writer = new CsvWriter();

        ArrayList<Integer> sizes = new ArrayList<>();
        sizes.add((int) Math.pow(10,3));
        //sizes.add((int) Math.pow(10,4));
        //sizes.add((int) Math.pow(10,5));
        //sizes.add((int) Math.pow(10,6));

        for (Integer size: sizes) {
            ArrayList<Integer> randInts = (ArrayList<Integer>) generator.createRandom(size);

            for (int i = 5; i < 26; i++) { // I sample through all the M values and test the time in miliseconds
                long first = System.currentTimeMillis();
                quickSorterCut.sort(generator.getComparator(),randInts,i);
                long second = System.currentTimeMillis();
                long result = second - first;
                writer.writeForMBenchmark("./Benchmark-M.txt",i,result,size);
                //System.out.println("For an M:" + i + " it took " + result + " miliseconds");
            }
        }
    }
}
