package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RandomizedTreeMap<K,V> implements Map<K,V>{
    private Node<K,V> head;
    private int size;
    private final Comparator<K> comparator;
    private ArrayList<K> keys;

    public RandomizedTreeMap(Comparator<K> comparator){
       this.comparator = comparator;
       size = 0;
       head = null;
    }

    @Override
    public int size() {return size;}

    @Override
    public boolean isEmpty() {return size == 0;}

    private Node<K,V> rotateLeft(@NotNull Node<K,V> node){
        final @NotNull Node<K,V> result = node.getRight();
        node.setRight(result.getLeft());
        result.setLeft(node);
        return result;
    }
    private Node<K,V> rotateRight(@NotNull Node<K,V> node){
        final @NotNull Node<K,V> result = node.getLeft();
        node.setLeft(result.getRight());
        result.setRight(node);
        return result;
    }

    @Override
    public boolean containsKey(@NotNull K key) {return find(head,key) != null;}

    @Override
    public V get(@NotNull K key) {
        final Node<K,V> node = find(head,key);
        if (node != null){
            return node.getValue();
        }
        return null;
    }

    @Override
    public V put(@NotNull K key, V value) {
        V previous = get(key);
       int random  = (int) (Math.random() * 100);
       if (random < 50){
          head = rootPut(this.head, key, value);
       }else{
           head = put(this.head,key,value);
       }
        return previous;
    }


    private Node<K,V> put(Node<K,V> node,@NotNull K key, V value) {
        if (node == null){
            size++;
            return new Node<>(key,value);
        }else{
        int cmp = comparator.compare(key, node.getKey());

        if (cmp < 0) node.setLeft(put(node.getLeft(),key,value));

        else if (cmp > 0) node.setRight(put(node.getRight(),key,value));

        else node.setValue(value);
        }
        return node;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }
    private Node<K,V> rootPut(Node<K,V> node, K key, V value){
        if (node == null){
            size++;
            return new Node<>(key,value);
        }else{
            int cmp = comparator.compare(key, node.getKey());
            if (cmp <0){
                node.setLeft(rootPut(node.getLeft(),key,value));
                return rotateRight(node);
            }
            else if (cmp > 0){
                node.setRight(rootPut(node.getRight(),key,value));
                return rotateLeft(node);
            }else{
                node.setValue(value);
                return node;
            }
        }
    }

    @Override
    public Iterator<K> keys() {
      keys = new ArrayList<>(size);
      getInOrder(head);
      return keys.iterator();
    }
    private void getInOrder(Node<K,V> node){
        if (node == null) return;
        getInOrder(node.getLeft());
        keys.add(node.getKey());
        getInOrder(node.getRight());
    }
    private Node<K,V> find(Node<K,V> node, K key){
        if (node == null) return null;
        int cmp = comparator.compare(key,node.getKey());
        if (cmp == 0) return node;
        else if (cmp <0) return find(node.getLeft(),key);
        else return find(node.getRight(),key);
    }

}
