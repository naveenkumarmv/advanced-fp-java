package patternmatching.list;


import java.util.Arrays;
import java.util.Iterator;

import static patternmatching.list.Result.*;

public class ListFunctions {

    public static <E> int size(List<E> list){
        return list.match(0, (head, tail) -> 1 + size(tail));
    }


    public static <E> List<E> list(E... data){
        Iterator<E> iterator = Arrays.stream(data).iterator();
        return list(iterator);
    }

    public static <E> List<E> list(Iterator<E> iterator){
        return !iterator.hasNext()? new None<>() : new LinkedList<>(iterator.next(), list(iterator));
    }

    public static boolean isSorted(List<Integer> list){
        return check(list).match(false, true, t -> true);
    }
    public static Result<Integer> check(List<Integer> list){
        return list.match(
                yes(),
                (head, tail) -> check(tail).match(no(), top(head), top -> top <= head ? top(head): no())
        );
    }


}
