package anaydis.sort;

import anaydis.sort.gui.SorterListener;


public class Listener implements SorterListener {
    private int comparison, swap, equals;

    public Listener() {
        comparison = 0;
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
    public void greater(int i, int j) {comparison++;}

    @Override
    public void swap(int i, int j) {swap++;}

    public int getSwap() {return swap;}

    public int getEquals() {return equals;}

    public int getComparison() {return comparison;}
}