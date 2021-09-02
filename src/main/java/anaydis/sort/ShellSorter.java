package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class ShellSorter extends AbstractSorter{
    HSorter hsorter = new HSorter();
    ShellSorter() {
        super(SorterType.SHELL);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

            for (int h = 4;h>0; h/=3){
                hsorter.sort(comparator,list);
            }
        }
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int h){
        hsorter.sort(comparator,list,h);
    }
    public HSorter getHsorter(){ return hsorter;}
}
