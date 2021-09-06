package anaydis.sort;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value,Node<T> next){
        this.value = value;
        this.next = next;
    }
    public Node(){
        value = null;
        next = null;
    }

    public Node<T> getNext() {return next;}

    public T getValue() {return value;}
}
