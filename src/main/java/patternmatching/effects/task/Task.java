package patternmatching.effects.task;

import java.util.function.Function;

public interface Task<E> {

    E execute();

    default <F> Task<F> map(Function<E, F> function){
        return new ChainedImmediateTask<E, F>(this, function);
    }

    default <F> Task<F> flatMap(Function<E, Task<F>>function){
        return new ChainedDelayedTask<E, F>(this, function);
    }

}
