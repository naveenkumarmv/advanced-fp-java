import patternmatching.example.Fibonacci;
import org.testng.annotations.Test;

import static patternmatching.example.Fibonacci.fibonacci;
import static org.testng.Assert.assertEquals;

public class TestFibonacci {

    @Test
    public void test(){
        assertEquals(0, fibonacci(0));
        assertEquals(1, fibonacci(1));
        assertEquals(1, Fibonacci.fibonacci(2));
    }
}
