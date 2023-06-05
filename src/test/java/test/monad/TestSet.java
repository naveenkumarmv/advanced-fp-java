package test.monad;

import algebra.CharFunctions;
import org.testng.annotations.Test;
import patternmatching.set.Set;

import static org.testng.AssertJUnit.assertEquals;

public class TestSet {

    @Test
    public void testSets(){
        Set<String> set = new Set<>("hello", "hi", "help");
        assertEquals(3, set.size());
        assertEquals(6, set.flatMap(CharFunctions::toSet).size());
    }

}
