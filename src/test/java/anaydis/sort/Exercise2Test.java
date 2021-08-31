package anaydis.sort;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exercise2Test {

    /** Bubble Sorter
     * Average & Worst: O(n^2)
     * Best:  O(N) & O(1) swaps (On Sorted input) 0 swaps and n comparissons
     *
     * Graphed in Python (Jupyter NoteBook) Link:
     * Report  in Juptyter NoteBook
     * **/
    public static void main(String[] args) {

    }




//Can I fix this? Put it all in one method
    public void Ascending(SorterType type, int length, String path) throws IOException{
        SorterProviderImpl provider = new SorterProviderImpl();
        AbstractSorter sorter = (AbstractSorter) provider.getSorterForType(type);
        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        ArrayList<Integer> list = (ArrayList<Integer>) intGenerator.createAscending(length);
        ListenerImpl listener = new ListenerImpl();
        sorter.addSorterListener(listener);
        sorter.sort(intGenerator.getComparator(),list);
        CsvWriter csv = new CsvWriter();
        csv.write("Benchmark.csv","Ascending",listener,type,length);
        sorter.removeSorterListener(listener);
    }
    public void Random(SorterType type, int length, String path) throws IOException{
        SorterProviderImpl provider = new SorterProviderImpl();
        AbstractSorter sorter = (AbstractSorter) provider.getSorterForType(type);
        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        ArrayList<Integer> list = (ArrayList<Integer>) intGenerator.createAscending(length);
        ListenerImpl listener = new ListenerImpl();
        sorter.addSorterListener(listener);
        sorter.sort(intGenerator.getComparator(),list);
        CsvWriter csv = new CsvWriter();
        csv.write("Benchmark.csv","Random",listener,type,length);
        sorter.removeSorterListener(listener);
    }
    public void Descending(SorterType type, int length, String path) throws IOException{
        SorterProviderImpl provider = new SorterProviderImpl();
        AbstractSorter sorter = (AbstractSorter) provider.getSorterForType(type);
        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        ArrayList<Integer> list = (ArrayList<Integer>) intGenerator.createAscending(length);
        ListenerImpl listener = new ListenerImpl();
        sorter.addSorterListener(listener);
        sorter.sort(intGenerator.getComparator(),list);
        CsvWriter csv = new CsvWriter();
        csv.write("Benchmark.csv","Descending",listener,type,length);
        sorter.removeSorterListener(listener);
    }


}
