package anaydis.compression;

import org.junit.Test;
import java.io.*;

public class BurrowsTest {

    @Test
    public void burrowTest() throws IOException {
        BurrowsWheeler burrowsWheeler = new BurrowsWheeler();

        InputStream inputStreamA = new ByteArrayInputStream("BANANA".getBytes());
        InputStream inputStreamB = new ByteArrayInputStream("DRDOBBS".getBytes());
        OutputStream outputStreamA = new ByteArrayOutputStream();
        OutputStream outputStreamB = new ByteArrayOutputStream();


        burrowsWheeler.encode(inputStreamA, outputStreamA);
        burrowsWheeler.encode(inputStreamB, outputStreamB);


        // DRDOBBS OUTPUT = OBRSDDB5
        //byte[] bytes = {79,66,82,83,68,68,66,53};




    }

}
