package patternmatching.effects.either;

public record Right<L, R>(R r) implements Either<L, R> {
}
