package anaydis.sort;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public void write(String path, String order, Listener listener, SorterType sorterType, int size) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

            bufferedWriter.write(sorterType.toString() + "," + order + "," + listener.getComparison() + "," + listener.getSwap());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Saving error");
        }
    }
    public void writeForMBenchmark(String path, int m, long time, int size) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

            bufferedWriter.write(m + "," + time + "," + size);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Saving error");
        }
    }
    public void writeForMergeSorts(String path, SorterType type, long time, int size) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

            bufferedWriter.write(type.toString() + "," + time + "," + size);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Saving error");
        }
    }
    public void writeHeaders(String path, String header){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
            bufferedWriter.write(header);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Saving error");
        }
    }

    public void writeForQuijote(String path, String mapType, int size,long time,int misses){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

            bufferedWriter.write(mapType + "," + size + "," + time + "," + misses);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Saving error");
        }
    }
}
