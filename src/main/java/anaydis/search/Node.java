package anaydis.search;

public class Node<K,V> {
    private Node<K,V> left;
    private Node<K,V> right;
    private V value;
    private final K key;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }

    public Node(K key, V value, Node<K,V> left, Node<K,V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public V getValue() {return value;}

    public K getKey() {return key;}

    public Node<K, V> getLeft() {return left;}

    public Node<K, V> getRight() {return right;}

    public void setRight(Node<K, V> node) {right = node;}

    public void setLeft(Node<K, V> node) {left = node;}

    public void setValue(V value) {this.value = value;}

}
