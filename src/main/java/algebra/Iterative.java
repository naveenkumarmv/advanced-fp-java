package algebra;

public class Iterative {

    <E> E fold (E[] data, Monoid<E>monoid){
        E result = monoid.identity();
        for(E e:data)
            result = monoid.operator().apply(result, e);
        return result;
    }
}
