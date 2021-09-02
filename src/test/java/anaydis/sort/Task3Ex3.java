package anaydis.sort;
import java.io.IOException;
import java.util.ArrayList;


public class Task3Ex3 {


    public static void main(String[] args) throws IOException {
        Task3Ex3 shellSequenceTest = new Task3Ex3();
        int[] seq1 = {1, 8, 23, 77, 281, 1073, 4193, 16577};
        int[] seq2 = {1, 4, 13, 40, 121, 364, 1093, 3280, 984};

        for (int h : seq1) {
            shellSequenceTest.AverageCase(100, h);
            shellSequenceTest.AverageCase(1000, h);
            shellSequenceTest.AverageCase(5000, h);
        }
        for (int h : seq2) {
            shellSequenceTest.AverageCase(100, h);
            shellSequenceTest.AverageCase(1000, h);
            shellSequenceTest.AverageCase(5000, h);
        }
    }


    public void AverageCase(int length, int h) throws IOException{
        ShellSorter sorter = new ShellSorter();
        IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        ArrayList<Integer> list = (ArrayList<Integer>) generator.createRandom(length);
        ListenerImpl listener = new ListenerImpl();

        sorter.getHsorter().addSorterListener(listener);
        sorter.sort(generator.getComparator(), list,h);
        CsvWriter writer = new CsvWriter();
        writer.write("ShellExercise3.csv","Average Case",listener,sorter.getType(),h);
    }

}
