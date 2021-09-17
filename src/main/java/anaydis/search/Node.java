package anaydis.search;

public class Node<K,V> {
    public Node<K,V> left;
    public Node<K,V> right;
    public V value;
    public K key;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }

    public V getValue() {return value;}

    public K getKey() {return key;}

    public Node<K, V> getLeft() {return left;}

    public Node<K, V> getRight() {return right;}
}
