package patternmatching.effects.either;

public record Left<L, R>(L left) implements Either<L, R> {
}
