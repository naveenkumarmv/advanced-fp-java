package patternmatching.set;

import algebra.Monoid;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class Set<E> {

    private final HashSet<E> dSet = new HashSet<>();

    public Set(){

    }
    public Set(Collection<E> data){
        dSet.addAll(data);
    }

    public Set(E... data){
       for(E datum:data)
           dSet.add(datum);
    }

    public <F> Set<F> map(Function<E, F> mapper){
        Set<F>set = new Set<>();
        dSet.forEach(e -> set.dSet.add(mapper.apply(e)));
        return set;
    }

    public Set<E> filter(Predicate<E> predicate){
        Set<E> result = new Set<>();
        dSet.forEach(e -> {
            if(predicate.test(e))
                result.dSet.add(e);
        });
        return result;
    }

    public Set<E> union(Set<E> set){
        Set<E> copy = new Set<>();
        copy.dSet.addAll(dSet);
        copy.dSet.addAll(set.dSet);
        return copy;
    }

    public E fold(Monoid<E>monoid){
        E zero = monoid.identity();
        for(E e : dSet)
            zero = monoid.operator().apply(zero, e);;
        return zero;
    }

    public <F> Set<F> flatMap(Function<E,Set<F>> mapper){
        Set<Set<F>> sets = map(mapper);
        Set folded = sets.fold(new SetUnionMonoid());
        return folded;
    }

    public int size(){
        return dSet.size();
    }
}
