package anaydis.sort;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public void write(String path, String order, ListenerImpl listener, SorterType sorterType, int size) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

            bufferedWriter.write(sorterType.toString() + "," + order + "," + listener.getComparisson() + "," + listener.getSwap());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Saving error");
        }
    }
}
