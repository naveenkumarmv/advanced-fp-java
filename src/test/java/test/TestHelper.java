package test;

import algebra.Monoid;
import patternmatching.list.LinkedList;
import patternmatching.list.List;
import patternmatching.list.None;

import java.util.function.BinaryOperator;

import static patternmatching.list.ListFunctions.list;

public class TestHelper {
    public static List<Integer> testList() {
        return list(1, 2, 3);
    }

    public static List<Integer> testList(int n){
        return new LinkedList<Integer>(n, n == 0 ? new None<Integer>() : testList(n - 1) );
    }

    public static Monoid<Integer> getAdditionIntegerMonoid() {
        return new Monoid<Integer>() {
            @Override
            public Integer identity() {
                return 0;
            }

            @Override
            public BinaryOperator<Integer> operator() {
                return (x, y) -> x + y;
            }
        };
    }
}
