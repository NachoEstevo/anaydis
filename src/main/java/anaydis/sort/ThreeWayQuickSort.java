package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class ThreeWayQuickSort extends AbstractSorter { //Efficient with duplicate keys. Keep the duplicate keys
    int i , j;
    public ThreeWayQuickSort() {super(SorterType.QUICK_THREE_PARTITION);}

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {sort(list , 0 , list.size()-1 , comparator);}


    private  <T> void sort(List<T> list , int l , int r , Comparator<T> comparator ){
        if (r <= l) return;
        i= 0;
        j= 0;
        patition(list , l , r , comparator);
        sort(list , l , j , comparator);
        sort(list , i , r , comparator);
    }

    private <T> void patition(List<T> list , int l , int r , Comparator<T> comparator){
        i = l-1;
        j = r;
        int p = l-1;
        int q = r;
        T v = list.get(r);
        while (true){
            while (greater(v , list.get(++i) , comparator)) if (i == r) break;

            while (greater(list.get(--j), v , comparator)){
                if (j == l) break;
            }
            if (i >= j) {
                break;
            }
            swap(list , i , j);
            if (equals(list.get(i) , v , comparator)){
                p++;
                swap(list , p , i);
            }
            if (equals(list.get(j) , v , comparator)){
                q--;
                swap(list , q , j);
            }
        }

        swap(list , i , r);

        j =  i - 1;
        for (int k = l; k < p ; k++ , j--) {
            swap(list , k , j);
        }
        i++;
        for (int k =  r-1; k > q; k-- , i++)  {
            swap(list , i , k);
        }
    }
}

