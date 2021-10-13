package anaydis.immutable;

import anaydis.search.Node;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BinaryTree<K, V> implements Map<K, V> {
    private final Node<K,V> head;
    private final int size;
    private final Comparator<K> comparator;
    private ArrayList<K> keys;

    private BinaryTree(Node<K,V> head, Comparator<K> comparator, int size) {
        this.comparator = comparator;
        this.head = head;
        this.size = size;
    }

    public BinaryTree(Comparator<K> comparator){
        this.comparator = comparator;
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(@NotNull K key) {
        return containsKey(key, head);
    }

    private boolean containsKey(K key, @Nullable Node<K,V> node) {

        if(node == null)return false;
        final int cmp = comparator.compare(key, node.getKey());
        if (cmp == 0){
            return true;
        }
        return cmp > 0? containsKey(key, node.getRight()):containsKey(key, node.getLeft());

    }

    @Nullable
    @Override
    public V get(@NotNull K key) {
        return get(key, head);

    }

    @Nullable
    private V get(K key, @Nullable Node<K,V> node) {
        if(node == null)return null;
        final int cmp = comparator.compare(key, node.getKey());
        if (cmp == 0){
            return node.getValue();
        }
        return cmp > 0? get(key, node.getRight()):get(key, node.getLeft());
    }

    @NotNull
    @Override
    public Map<K, V> put(@NotNull K key, V value) {
        Result result = put(key, value, head);
        return new BinaryTree<>(result.node, comparator, result.size);
    }

    private Result put(K key, V value, @Nullable Node<K,V> node) {
        if(node == null)return new Result(new anaydis.search.Node<>(key, value), size+1);
        int cmp = comparator.compare(node.getKey(), key);
        if (cmp>0){
            final Result r = put(key, value, node.getLeft());
            return new Result(new Node<>(node.getKey(), node.getValue(), r.node, node.getRight()), r.size);
        }
        else if(cmp == 0){
            return new Result(new anaydis.search.Node<>(key, value), size);
        }
        else{
            final Result r = put(key, value, node.getRight());
            return new Result(new Node<>(node.getKey(), node.getValue(), node.getLeft(), r.node), r.size);
        }
    }

    private class Result{
        anaydis.search.Node<K,V> node;
        int size;
        Result(anaydis.search.Node<K,V> node, int size) {
            this.node = node;
            this.size = size;
        }
    }

    @Override
    public Iterator<K> keys() {
        keys = new ArrayList<>(size);
        getInOrder(head);
        return keys.iterator();
    }
    private void getInOrder(anaydis.search.Node<K,V> node){
        if (node == null) return;
        getInOrder(node.getLeft());
        keys.add(node.getKey());
        getInOrder(node.getRight());
    }
}
