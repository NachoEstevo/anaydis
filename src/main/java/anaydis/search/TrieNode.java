package anaydis.search;

class TrieNode<V> {

    private V value;
    public static final int R = 256;
    public final TrieNode[] next = new TrieNode[R];

    public TrieNode() {

    }

    public TrieNode[] getNext() {
        return next;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public V getValue() {
        return value;
    }


}
