package anaydis.sort;

import java.io.IOException;
import java.util.ArrayList;

public class Exercise2Test {

    /** Bubble Sorter
     * Average & Worst: O(n^2)
     * Best:  O(N) & O(1) swaps (On Sorted input) 0 swaps and n comparissons
     *
     * Graphed in Python (Jupyter NoteBook) Link:
     * Report  in Juptyter NoteBook
     * **/

        public static void main(String[] args) throws IOException {
            Exercise2Test sorterTest = new Exercise2Test();
            ArrayList<SorterType> types = new ArrayList<>();
            types.add(SorterType.SELECTION);
            types.add(SorterType.INSERTION);
            types.add(SorterType.BUBBLE);
            types.add(SorterType.QUICK);
            types.add(SorterType.SHELL);

            ArrayList<Integer> sizes = new ArrayList<>();
            sizes.add(10);
            sizes.add(50);
            sizes.add(500);
            sizes.add(1000);

            /*for (SorterType type: types) {
                for (int size: sizes) {
                    sorterTest.Ascending(type,size);
                    sorterTest.Descending(type,size);
                    sorterTest.Random(type,size);
                }
            }*/
        }

//Can I fix this? Put it all in one method. Temporary solution
    private void Ascending(SorterType type, int length) throws IOException{
        SorterProviderImpl provider = new SorterProviderImpl();
        AbstractSorter sorter = (AbstractSorter) provider.getSorterForType(type);
        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        ArrayList<Integer> list = (ArrayList<Integer>) intGenerator.createAscending(length);
        ListenerImpl listener = new ListenerImpl();
        sorter.addSorterListener(listener);
        sorter.sort(intGenerator.getComparator(),list);
        CsvWriter csv = new CsvWriter();
        csv.write("./Benchmark.csv","Ascending",listener,type,length);
        sorter.removeSorterListener(listener);
    }
    private void Random(SorterType type, int length) throws IOException{
        SorterProviderImpl provider = new SorterProviderImpl();
        AbstractSorter sorter = (AbstractSorter) provider.getSorterForType(type);
        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        ArrayList<Integer> list = (ArrayList<Integer>) intGenerator.createRandom(length);
        ListenerImpl listener = new ListenerImpl();
        sorter.addSorterListener(listener);
        sorter.sort(intGenerator.getComparator(),list);
        CsvWriter csv = new CsvWriter();
        csv.write("./Benchmark.csv","Random",listener,type,length);
        sorter.removeSorterListener(listener);
    }
    private void Descending(SorterType type, int length) throws IOException{
        SorterProviderImpl provider = new SorterProviderImpl();
        AbstractSorter sorter = (AbstractSorter) provider.getSorterForType(type);
        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        ArrayList<Integer> list = (ArrayList<Integer>) intGenerator.createDescending(length);
        ListenerImpl listener = new ListenerImpl();
        sorter.addSorterListener(listener);
        sorter.sort(intGenerator.getComparator(),list);
        CsvWriter csv = new CsvWriter();
        csv.write("./Benchmark.csv","Descending",listener,type,length);
        sorter.removeSorterListener(listener);
    }
}
