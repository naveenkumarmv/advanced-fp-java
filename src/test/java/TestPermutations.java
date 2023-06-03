import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestPermutations {

    @Test
    public void testPermutations(){
        assertEquals(24, Permutations.permutations("abcd").size());
    }
}
