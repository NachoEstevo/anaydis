package anaydis.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MoveToFront {
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

    public void encode(InputStream input, OutputStream out) throws IOException {
        int c;
        while ((c = input.read()) != -1) {
            out.write(_table[c]);
            out.write(0);
            add(c);
        }
    }

    public int decode(InputStream input, OutputStream out) throws IOException {
        int c;
        int i = 0;
        while ((c = input.read()) != -1) {
            if (c == 0) {
                out.write(i);
                return i;
            }
            i = _table[i];
            out.write(i);
            add(i);
        }
        return i;
    }
}
