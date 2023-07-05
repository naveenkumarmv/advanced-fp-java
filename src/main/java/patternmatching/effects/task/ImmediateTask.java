package patternmatching.effects.task;

public class ImmediateTask<F> implements Task<F>{

    private final F f;
    public ImmediateTask(F f){
        this.f = f;
    }
    @Override
    public F execute() {
        return f;
    }
}
