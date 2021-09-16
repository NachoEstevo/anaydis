package anaydis.sort;


import anaydis.search.Map;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<K, V> implements Map<K , V> {

    private final List<K> keys;
    private final List<V> values;
    private int size;
    private final Comparator<K> comparator;

    public ArrayMap( Comparator<K> comparator){
        this.comparator = comparator;
        this.size = 0;
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    public int size() {return keys.size();}

    @Override
    public boolean containsKey(@NotNull K key) {return indexOf(key) != -1;}

    @Override
    public V get(@NotNull K key) {
        if (containsKey(key)){
            return null;
        }
        return values.get(indexOf(key));
    }

    @Override
    public V put(@NotNull K key, V value) {
        final int index = find(key, 0, keys.size()-1);
        if(index >= 0){
            return values.set(index, value);
        }else {
            keys.add(-index - 1, key);
            values.add(-index - 1, value);
            return null;
        }
    }

    public void remove(K key){
        int index = indexOf(key);
        if (index != -1){
            for (int i = index+1 ; i < size-1 ; i++) {
                keys.set(i-1 , keys.get(i));
                values.set(i-1 , values.get(i));
            }
            size--;
        }
    }

    public int find(K key , int high , int low){
        if (low > high) return -(low+1);

        int middle = (low + high) / 2;
        int cmp = comparator.compare(key , keys.get(middle));
        if (cmp == 0){
            return middle;
        }
        if (cmp < 0){
            find(key , low , middle-1 );
        }
        find(key , middle+1 , high);
        return middle;
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Iterator<K> keys() {return keys.iterator();}

    private int indexOf( @NotNull Object key){
        for (int i = 0; i <size -1 ; i++) {
            if (key.equals(keys.get(i))) {
                return i;
            }
        }
        return -1;
    }

}
