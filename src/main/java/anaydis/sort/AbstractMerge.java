package anaydis.sort;

import anaydis.sort.gui.SorterListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractMerge extends AbstractSorter{
    public List<SorterListener> listeners;

    AbstractMerge(SorterType type){
        super(type);
        listeners = new ArrayList<>();
    }

    public <T> void merge(List<T> list , int low , int middle, int high , Comparator<T> comparator){
        int l2 = middle +1;

        if (greater(list.get(l2) , list.get(middle) , comparator)){
            return;
        }
        while (low <= middle && l2 <= high){

            if (greater( list.get(l2), list.get(low),  comparator)){
                low++;
            }else{
                T v = list.get(l2);
                int index = l2;

                while (index != low){
                    list.set(index , list.get(index-1));
                    index--;
                }
                list.set(low , v);

                low++;
                middle++;
                l2++;
            }
        }
    }

}
