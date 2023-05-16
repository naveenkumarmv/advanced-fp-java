package patternmatching.tree;

public sealed interface Tree<E> permits None, Node {
    default  <F> F match(F f, TriFunction<E , Tree<E>, Tree<E>, F> function){
        return switch (this){
            case None none -> f;
            case Node(E val, Tree<E> left, Tree<E> right) -> function.apply(val, left, right);
        };
    }
}
