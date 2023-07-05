package patternmatching.effects.task;

import java.util.function.Function;

public class ChainedImmediateTask<E, F> implements Task<F> {

    private final Task<E> task;

    private final Function<E, F> function;

    public ChainedImmediateTask(Task<E> task, Function<E, F> function) {
        this.task = task;
        this.function = function;
    }

    @Override
    public F execute() {
        return function.apply(task.execute());
    }
}
