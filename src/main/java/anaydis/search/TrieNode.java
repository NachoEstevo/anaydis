package anaydis.search;

class TrieNode<V> {

    private V value;
    public static final int R = 256;
    @SuppressWarnings("unchecked") //Not a solution
    public final TrieNode<V>[] next = new  TrieNode[R];

    public TrieNode() {

    }
    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }


}
