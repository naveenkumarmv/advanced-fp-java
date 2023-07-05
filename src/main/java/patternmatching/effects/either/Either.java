package patternmatching.effects.either;

import java.util.function.Function;

public sealed interface Either<L, R> permits Left, Right{
    default <F> F match(Function<L, F> lFunction, Function<R, F> rfFunction){
        return switch(this){
            case Left(L l) -> lFunction.apply(l);
            case Right(R r) -> rfFunction.apply(r);
        };
    }

    default <F> Either<L, F> map(Function<R, F> function){
        return match(Left::new, r -> new Right<L, F>(function.apply(r)));
    }

    default <F> Either<L, F> flatMap(Function<R, Either<L, F>> function){
        return match(Left::new, function);
    }

    default <F> F fold (Function<L, F> lFunction, Function<R, F> rFunction){
        return match(lFunction, rFunction);
    }
}
