package patternmatching.effects.task;

import java.util.function.Function;

public class ChainedDelayedTask<E,F> implements Task<F> {

    private final Task<E> task;

    private final Function<E, Task<F>> function;

    public ChainedDelayedTask(Task<E> task, Function<E, Task<F>> function) {
        this.task = task;
        this.function = function;
    }

    @Override
    public F execute() {
        return function.apply(task.execute()).execute();
    }
}
