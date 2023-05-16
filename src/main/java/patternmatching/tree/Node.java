package patternmatching.tree;

public record Node<E>(E value, Tree<E> left, Tree<E> right) implements Tree<E> {

}
