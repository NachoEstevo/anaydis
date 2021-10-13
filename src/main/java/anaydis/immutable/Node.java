package anaydis.immutable;

import org.jetbrains.annotations.NotNull;

public class Node<T> implements List<T> {
    private final T head;
    private final List<T> tail;

    public Node(T head, List<T> tail){
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public @NotNull List<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public @NotNull List<T> reverse() {
        List<T> reversed = List.nil(), current = this;
        while (!current.isEmpty()){
            reversed = List.cons(current.head(), reversed);
            current = current.tail();
        }
        return reversed;
    }

    //public int size(List<T> node){return isEmpty() ?  0 : 1 + size(tail());}


}
