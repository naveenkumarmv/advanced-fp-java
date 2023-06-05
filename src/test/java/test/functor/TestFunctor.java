package test.functor;

import algebra.Monoid;
import org.testng.annotations.Test;
import patternmatching.list.LinkedList;
import patternmatching.list.List;
import patternmatching.list.ListFunctions;
import patternmatching.list.None;
import test.TestHelper;

import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestFunctor {

    @Test
    public void testLaws(){
        List<Integer> list = new LinkedList<>(1, new None<>());
        assertTrue(list.equals(list.map(Function.identity())));
        Function<String, Integer> f = String::length;
        Function<Integer, Boolean> g = x -> x % 2 == 0;
        Function<String, Boolean> h = f.andThen(g);
        List<String> list1 = new LinkedList<>("hello", new LinkedList<>("hi", new None<>()));
        assertTrue(list1.map(f).map(g).equals(list1.map(h)));
    }

    @Test
    public void testHomoMorphism(){
        String s = "I love functional programing";
        int length = s.length();
        int i = new Random().nextInt(length);
        String s1 = s.substring(0, i);
        String s2 = s.substring(i, length);
        List<String> list = ListFunctions.list(s1, s2);
        int size = list.fold(
                new Monoid<String>() {
                    @Override
                    public String identity() {
                        return "";
                    }

                    @Override
                    public BinaryOperator<String> operator() {
                        return (x, y) -> x + y;
                    }
                }
        ).length();
        assertEquals(size, list.map(String::length).fold(TestHelper.getAdditionIntegerMonoid()));
    }
}
