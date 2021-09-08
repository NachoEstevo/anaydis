package anaydis.sort;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class MergeSortsAnalysis {

    @Test
    public void MergeTests() throws IOException {
        MergeSorterBottomUp bottomUp = new MergeSorterBottomUp();
        MergeSorterTopDown topDown = new MergeSorterTopDown();
        IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        CsvWriter writer = new CsvWriter();

        ArrayList<Integer> sizes = new ArrayList<>();
        sizes.add(100);
        sizes.add(500);
        sizes.add(1000);
        sizes.add(2500);
        sizes.add(5000);

        for (int size: sizes) {
            ArrayList<Integer> randInts = (ArrayList<Integer>) generator.createRandom(size);

            long startBottom = System.currentTimeMillis();
            bottomUp.sort(generator.getComparator(),randInts);
            long endBottom = System.currentTimeMillis();
            long result = endBottom - startBottom;
            writer.writeForMergeSorts("./MergeSorters-Benchmark.txt",bottomUp.getType(),result,size);

            long startTop = System.currentTimeMillis();
            bottomUp.sort(generator.getComparator(),randInts);
            long endTop = System.currentTimeMillis();
            long resultTop = endTop - startTop;
            writer.writeForMergeSorts("./MergeSorters-Benchmark.txt",topDown.getType(),resultTop,size);
        }
    }
}
