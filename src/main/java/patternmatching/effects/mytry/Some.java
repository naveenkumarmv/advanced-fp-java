package patternmatching.effects.mytry;

public record Some<E>(E e) implements Try<E> {
}
