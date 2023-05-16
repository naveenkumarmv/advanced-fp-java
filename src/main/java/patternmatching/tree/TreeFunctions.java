package patternmatching.tree;

import static java.lang.Math.max;

public class TreeFunctions {
    public static <E> int size(Tree<E> tree){
        return tree.match(0, (root, left, right) -> 1 + size(left) + size(right));
    }

    public static <E> int depth(Tree<E> tree){
        return tree.match(0, (root, left, right) -> 1 + max(depth(left), depth(right)));
    }
}
