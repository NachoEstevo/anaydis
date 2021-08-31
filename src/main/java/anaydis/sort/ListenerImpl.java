package anaydis.sort;

import anaydis.sort.gui.SorterListener;


public class ListenerImpl implements SorterListener {
    private int comparisson, swap, equals;

    public ListenerImpl() {
        comparisson = 0;
        swap = 0;
        equals = 0;
    }

    @Override
    public void box(int from, int to) {}

    @Override
    public void copy(int from, int to, boolean copyToAux) {}

    @Override
    public void equals(int i, int j) {equals++;}

    @Override
    public void greater(int i, int j) {comparisson++;}

    @Override
    public void swap(int i, int j) {swap++;}

    public int getSwap() {return swap;}

    public int getEquals() {return equals;}

    public int getComparisson() {return comparisson;}

    public int Order() {return comparisson + swap + equals;}
}