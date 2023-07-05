package test;

import org.testng.annotations.Test;
import patternmatching.effects.task.DelayedTask;
import patternmatching.effects.task.Task;

public class TestTask {
    @Test
    public void testTask(){
        Task<String> task = new DelayedTask<>(() -> "Hello, World");
        Task<Boolean> booleanTask = task.map(String::length).map(l -> l % 2 == 0);
        System.out.println("about to execute the task");
        System.out.println(booleanTask.execute());
    }
}
