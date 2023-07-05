package patternmatching.effects.task;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DelayedTask<F> implements Task<F> {

    private final Supplier<F> supplier;
    public DelayedTask(Supplier<F> supplier){
        this.supplier = supplier;
    }
    @Override
    public F execute() {
        FutureTask<F> task = new FutureTask<>(new MyRunnable(100), supplier.get());
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(task);
        try {
            return task.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    class MyRunnable implements Runnable {

        private final long waitTime;

        public MyRunnable(int timeInMillis)
        {
            this.waitTime = timeInMillis;
        }

        @Override
        public void run()
        {
            try {
                // sleep for user given millisecond
                // before checking again
                Thread.sleep(waitTime);

                // return current thread name
                System.out.println(Thread
                        .currentThread()
                        .getName());
            }

            catch (InterruptedException ex) {
                Logger
                        .getLogger(MyRunnable.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

}
