package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class RandomizedTreeMap<K,V> implements Map<K,V>{
    private Node<K,V> head = null;
    private int size;
    private final Comparator<K> comparator;

    public RandomizedTreeMap(Comparator<K> comparator){
       this.comparator = comparator;
       size = 0;
    }

    @Override
    public int size() {return size;}

    @Override
    public boolean isEmpty() {return size == 0;}

    private Node<K,V> rotateLeft(@NotNull Node<K,V> node){
        final Node<K,V> result = node.getRight();
        node.right = result.getLeft();
        result.left = node;
        return result;
    }
    private Node<K,V> rotateRight(@NotNull Node<K,V> node){
        final Node<K,V> result = node.getLeft();
        node.left = result.getRight();
        result.right = node;
        return result;
    }

    @Override
    public boolean containsKey(@NotNull K key) {return find(head,key) != null;}

    @Override
    public V get(@NotNull K key) {
        Node<K,V> node = find(head,key);
        if (node != null) return node.getValue();
        return null;
    }

    @Override
    public V put(@NotNull K key, V value) {
        return null;
    }


    public Node<K,V> put(Node<K,V> node,@NotNull K key, V value) {
        if (node == null){
            size++;
            return  new Node<>(key,value);
        }else{
        int cmp = comparator.compare(key, node.getKey());

        if (cmp < 0) node.left = put(node.getLeft(),key,value);

        else if (cmp > 0) node.right = put(node.getRight(),key,value);

        else node.value = value;
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
                node.left = rootPut(node.getLeft(),key,value);
                return rotateLeft(node);
            }
            else if (cmp > 0){
                node.right = rootPut(node.getRight(),key,value);
                return rotateRight(node);
            }else{
                node.value = value;
                return node;
            }
        }
    }

    @Override
    public Iterator<K> keys() {
        Stack<Node<K,V>> stack = new Stack<>();

        return new Iterator<K>(){
            Node<K,V> aux = head;

            @Override
            public boolean hasNext(){
                return !(aux == null);
            }
            @Override
            public K next(){
                if (!hasNext()) throw new NoSuchElementException();
                while (aux != null){
                    stack.push(aux);
                    aux = aux.left;
                }
                Node<K,V> previous = stack.pop();
                aux = previous.right;
                return previous.key;
            }
        };
    }
    private Node<K,V> find(Node<K,V> node, K key){
        if (node == null) return null;
        int cmp = comparator.compare(key,node.key);
        if (cmp == 0) return node;
        else if (cmp <0) return find(node.left,key);
        else return find(node.right,key);
    }
}
