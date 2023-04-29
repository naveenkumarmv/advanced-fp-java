package patternmatching.list;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public sealed interface List<E> extends Iterable<E> permits None, LinkedList {

    default <F> F match(Supplier<F> supplier, BiFunction<E, List<E>, F> function){
        return switch(this){
            case None<E> ignored -> supplier.get();
            case LinkedList (E head, List<E> tail) -> function.apply(head, tail);
        };
    }
    default <F> List<F>map(Function<E, F> function){
        return match(() -> new None<>(), (head, tail) -> new LinkedList<>(function.apply(head), tail.map(function)));
    }

    default Iterator<E> iterator() {
        return new ListIterator(this);
    }
    class ListIterator<E> implements Iterator<E>{

        private List<E> list;

        public ListIterator(List<E> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return switch (list) {
                case None<E> ignored -> false;
                case LinkedList (E head, List<E> tail) -> true;
            };
        }

        @Override
        public E next() {
            switch (list) {
                case None<E> ignored : return null;
                case LinkedList (E head, List<E> tail) : {
                    list = tail;
                    return head;
                }
                default : return null;
            }
        }
    }

}
