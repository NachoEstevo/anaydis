package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class CircularString implements Comparable<CircularString>{
    /**
     * Receives a char[] as an input and indexes a pointer that can always point to the next char in the String.
     * If it has reached the end, the "next" will be the first char again.
     */
    final private char[] string;
    final private int start;
    final private int length;

    CircularString(char[] string) {
        this.string = string;
        this.length = string.length;
        this.start = 0;
    }

    private CircularString(char[] string, int start){
        if (string.length == 0 || start < 0)throw new IllegalArgumentException();
        this.string = string;
        this.start = start;
        this.length = string.length;
    }

    @NotNull
    CircularString shift(){
        int newStart = start - 1;
        if (newStart == -1) newStart = length - 1;
        return new CircularString(string, newStart);
    }

    int length(){return length;}

    @NotNull
    Iterator<Character> iterator(){
        return new Iterator<>() {
            private int index = start;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < string.length;
            }

            @Override
            public Character next() {
                count++;
                char c = string[index++];
                if (index == string.length) index = 0;
                return c;
            }
        };
    }

    @Override
    public int compareTo(@NotNull CircularString o) {
        if (o.length != this.length)throw new IllegalArgumentException("Only same length CircleString are comparable");
        final Iterator<Character> it1 = this.iterator(), it2 = o.iterator();
        int cmp = Character.compare(it1.next(), it2.next());
        while (cmp == 0 && it1.hasNext()){
            cmp = Character.compare(it1.next(), it2.next());
        }
        return cmp;
    }

    @NotNull
    @Override
    public String toString() {
        final StringBuilder stringBuilder  = new StringBuilder();
        final Iterator<Character> characterIterator = this.iterator();
        while (characterIterator.hasNext()){
            stringBuilder.append(characterIterator.next());
        }
        return stringBuilder.toString();
    }

    char last() {
        if (start == 0){
            return string[length - 1];
        }
        return string[start - 1];
    }

    int getStart() {return start;}
}

