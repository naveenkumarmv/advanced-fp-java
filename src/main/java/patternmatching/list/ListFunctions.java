package patternmatching.list;


import static patternmatching.list.Result.*;

public class ListFunctions {

    public static <E> int size(List<E> list){
        return list.match(0, (head, tail) -> 1 + size(tail));
    }

    public static <E> boolean areEqual(List<E> first, List<E> second){
        return first.match(
                second.match(true, (h, t) -> false),
                (E head, List<E> tail) -> second.match(false, (h, t) -> h.equals(head) && areEqual(tail, t))
        );
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
