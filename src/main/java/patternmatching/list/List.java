package patternmatching.list;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public sealed interface List<E> extends Iterable<E> permits None, LinkedList {

    default <F> F match(F zero, BiFunction<E, List<E>, F> function){
        return switch(this){
            case None<E> ignored -> zero;
            case LinkedList (E head, List<E> tail) -> function.apply(head, tail);
        };
    }

    default <F> List<F>map(Function<E, F> function){
        return match(new None<>(), (head, tail) -> new LinkedList<>(function.apply(head), tail.map(function)));
    }

    default <R> R fold(R zero, BiFunction<R, E, R> reducer){
        return match(zero, (head, tail) ->  reducer.apply(tail.fold(zero, reducer), head));
    }
    default  <R> List<R> flatmap(Function<E, List<R>> function){
        return map(function).fold(new None<R>(), (List<R> f, List<R> s) -> concatenate(f, s));
    }

    static <E> List<E> concatenate(List<E> first, List<E> second){
        return first.match(second, (head, tail) -> new LinkedList<E>(head, concatenate(tail, second)));
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

    default void consume(Manager manager, BiConsumer<E, List<E>> consumer){
        switch(this){
            case None<E> ignored : manager.apply();
                break;
            case LinkedList (E head, List<E> tail) : consumer.accept(head, tail);
        };
    }
}
