package anaydis.search;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RWayTrieMap<V> implements Map<String,V>{
    private TrieNode<V> head;
    private static final int R = 256;
    private int size;

    public RWayTrieMap(){
        size = 0;
        head = null;
    }


    public V put(@NotNull String key, V val) {
        V previous = get(key);
        head = put(head, key, val, 0);
        size++;
        return previous;
    }


    private TrieNode<V> put(TrieNode<V> node, String key, V val, int d) {
        if (node == null) node = new TrieNode<>();
        if (d == key.length()) { node.setValue(val); return node; }
        char c = key.charAt(d);
        node.next[c] = put(node.next[c], key, val, d+1);
        return node;
    }

    public boolean contains(String key)
    { return get(key) != null; }

    @Override
    public int size() {
        return size;
    }
    @Override
    public Iterator<String> keys() {
        List<String> list = new ArrayList<>();
        collect(head, "", list);
        return list.iterator();
    }

    private void collect(TrieNode<V> node, String prefix, List<String> list) {
        if (node == null) return;
        if (node.getValue() != null) list.add(prefix);
        for (char c = 0; c < R; c++)
            collect(node.next[c], prefix + c, list);
    }


    @Override
    public boolean containsKey(@NotNull String key) {return find(head,key,0) != null;}

    public V get(@NotNull String key) {
        TrieNode<V> node = get(head, key, 0);
        if (node == null) return null;
        return (V) node.getValue();
    }

    private TrieNode<V> get(TrieNode<V> node, String key, int d){
        if (node == null) return null;
        if (d == key.length()) return node;
        char c = key.charAt(d);
        return get(node.next[c], key, d+1);
    }
    private TrieNode<V> find(TrieNode<V> node , String key , int level){
        if (node == null) return null;
        if (level == key.length()) return node;
        char c = key.charAt(level);
        return find(node.next[c], key, level+1);

    }

    @Override
    public boolean isEmpty() {
        return Map.super.isEmpty();
    }
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

}
