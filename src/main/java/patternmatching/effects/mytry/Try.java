package patternmatching.effects.mytry;

import java.util.function.Function;
import java.util.function.Supplier;

public sealed interface Try<E> permits Exception, Some{

    default <F> F match(Supplier<F> supplier, Function<E, F> function){
        return switch (this){
            case Exception e -> supplier.get();
            case Some(E e) -> function.apply(e);
        };
    }

    default <F> Try<F> map(Function<E, F> function){
        return match(getSupplier(), e-> new Some<>(function.apply(e)));
    }

    default <F> Try<F> flatmap(Function<E, Try<F>> function){
        return match(getSupplier(), function);
    }

    private <F> Supplier<Try<F>> getSupplier() {
        return () -> (Try<F>) this;
    }

}
