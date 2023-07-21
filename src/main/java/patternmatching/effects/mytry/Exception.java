package patternmatching.effects.mytry;

public record Exception<E>(java.lang.Exception e) implements Try<E> {
}
