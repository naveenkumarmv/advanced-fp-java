package patternmatching.set;

import algebra.Monoid;

import java.util.function.BinaryOperator;

public class SetUnionMonoid<E>implements Monoid<Set<E>> {


    @Override
    public Set<E> identity() {
        return new Set<>();
    }

    @Override
    public BinaryOperator<Set<E>> operator() {
        return Set::union;
    }
}
