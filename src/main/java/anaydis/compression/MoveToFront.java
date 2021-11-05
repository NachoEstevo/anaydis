package anaydis.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MoveToFront {

    private int[] _table;
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

    public void encode(int c, OutputStream out) throws IOException {
        int i = _table[c];
        if (i == -1) {
            throw new RuntimeException("Character not in table");
        }
        int j = 0;
        while (i > 0) {
            out.write(i & 1);
            i >>= 1;
            j++;
        }
        for (int k = 0; k < 256; k++) {
            if (_table[k] == j) {
                _table[k] = _size++;
            }
        }
    }

    public int decode(InputStream in) throws IOException {
        int i = 0;
        while (in.read() == 0) {
            i++;
        }
        int j = 0;
        for (int k = 0; k < 256; k++) {
            if (_table[k] == i) {
                _table[k] = j;
                j++;
            }
        }
        return i;
    }
}
