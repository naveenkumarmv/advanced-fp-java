package list;

import patternmatching.list.LinkedList;
import patternmatching.list.None;

public class TestHelper {
    public static LinkedList<Integer> testList() {
        return new LinkedList<>(1, new LinkedList<>(2, new LinkedList<Integer>(3, new None<>())));
    }
}
