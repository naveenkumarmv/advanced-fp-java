package patternmatching.effects.option;

import java.util.function.Function;

public sealed interface Option<E>  permits None, Some {

    default <F> F match(F zero, Function<E, F> function){
        return switch(this){
            case None<E> ignored -> zero;
            case Some (E data) -> function.apply(data);
        };
    }

    default <F> Option<F> map(Function<E, F> function){
        return match(new None<F>(), data -> new Some<>(function.apply(data)));
    }

    default <F> Option<F> flatMap(Function<E, Option<F>>function){
        return match(new None<F>(), function);
    }
}
