package anaydias.search;


import anaydis.search.Map;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<K, V> implements Map<K , V> {

    private final List<K> keys;
    private final List<V> values;
    private int size; //Do I need to have a size or can I just use keys.size()
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
       final int index = indexOf(key);
       if (index != -1){
           return values.get(index);
       }
       return null;
    }

    @Override
    public V put(@NotNull K key, V value) {
        int index = find(key, 0, size-1);
        if(index < 0){
          index = (-index) - 1;
          keys.add(null);
          values.add(null);
          moveElementsRight(index);
          keys.set(index,key);
        }
        return values.set(index,value);
    }

    private void moveElementsRight(int index) {
        for (int i = size++; i > index; i--) {
            keys.set(i,keys.get(i-1));
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

    public int find(K key , int low , int high){
        if (low > high) return -(low+1);
        final int middle = (low + high) / 2;
        int cmp = comparator.compare(key , keys.get(middle));
        if (cmp == 0){
            return middle;
        }
        else if (cmp < 0){
            return find(key , low , middle-1 );
        }
        else {
            return find(key, middle + 1, high);
        }
    }

    @Override
    public void clear() {
        size = 0;
        keys.clear();
        values.clear();
    }

    @Override
    public Iterator<K> keys() {return keys.iterator();}

    private int indexOf( @NotNull K key) {
        final int index = find(key, 0, size - 1);
        if (index < 0) {
            return -1;
        } else {
            return index;
        }
    }

}
