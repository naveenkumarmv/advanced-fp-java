package patternmatching.effects.option;

public record Some<E>(E data) implements Option<E>  {
}
