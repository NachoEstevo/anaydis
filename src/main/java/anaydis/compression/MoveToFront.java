package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MoveToFront { //Implements Compressor. Class not Working
    private final int[] _table;
    private int _size;

    public MoveToFront() {
        _table = new int[256];
        _size = 0;
        for (int i = 0; i < 256; i++) {
            _table[i] = -1;
        }
    }

    public void add(int c) {
        if (_table[c] == -1) {
            _table[c] = _size++;
        }
    }


    public void encode(@NotNull InputStream input, @NotNull OutputStream out) throws IOException {
        int c;
        while ((c = input.read()) != -1) {
            out.write(_table[c]);
            out.write(0);
            add(c);
        }
    }

    public void decode(@NotNull InputStream input, @NotNull OutputStream out) throws IOException {
        int c;
        while ((c = input.read()) != -1) {
            int d = input.read();
            if (d == -1) {
                throw new IOException("Unexpected EOF");
            }
            out.write(c);
            add(d);
        }
    }

}
