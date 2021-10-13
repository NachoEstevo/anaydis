package anaydis.immutable;

import org.jetbrains.annotations.NotNull;

public class BankersQueue<T> implements Queue<T> { //Se manejan 2 listas.

    private final List<T> in;
    private final List<T> out;

    public BankersQueue(@NotNull List<T> in, @NotNull List<T> out){
        this.in = in;
        this.out = out;
    }

    BankersQueue() {
        this.in = List.nil();
        this.out = List.nil();
    }

    @Override
    public @NotNull BankersQueue<T> enqueue(@NotNull T value) {return new BankersQueue<>(List.cons(value, in), out);}


    @Override
    public @NotNull Result<T> dequeue() {
        if (out.isEmpty()){
            List<T> out = in.reverse();
            return new Result<>(out.head(), new BankersQueue<>(List.nil(), out.tail()));
        }
        return new Result<>(out.head(), new BankersQueue<>(in, out.tail()));
    }

    @Override
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

}