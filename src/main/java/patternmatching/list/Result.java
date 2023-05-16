package patternmatching.list;

import java.util.function.Function;

public sealed interface Result<E> permits No, Top, Yes{

    static <E> Result<E> no(){
        return new No();
    }

    static<E> Result<E> top(E e){
        return new Top(e);
    }

    static <E> Result<E> yes(){
        return new Yes();
    }

    default <F> F match(F f1, F f2, Function<E, F> function){
        return switch (this){
            case No no -> f1;
            case Yes yes -> f2;
            case Top (E e) -> function.apply(e);
        };
    }
}
