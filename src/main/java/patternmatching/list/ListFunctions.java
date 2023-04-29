package patternmatching.list;

import patternmatching.list.LinkedList;
import patternmatching.list.List;
import patternmatching.list.None;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ListFunctions {

    public static <E> int size(List<E> list){
        return list.match(() -> 0, (head, tail) -> 1 + size(tail));
    }

    public static <E, R> R fold(List<E> list, R zero, BiFunction<R, E, R> reducer){
        return list.match(() -> zero, (head, tail) ->  reducer.apply(fold(tail, zero, reducer), head));
    }

    public static <E> List<E> concatenate(List<E> first, List<E> second){
        return first.match(() -> second, (head, tail) -> new LinkedList<E>(head, concatenate(tail, second)));
    }
    public static <E, R> List<R> flatmap(List<E> list, Function<E, List<R>> function){
        List<List<R>> lists = list.map(function);
        return fold(lists, new None<R>(), (List<R> f, List<R> s) -> concatenate(f, s));
    }


}
