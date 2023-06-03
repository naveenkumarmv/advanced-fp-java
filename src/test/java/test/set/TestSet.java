package test.set;

import algebra.CharFunctions;
import org.testng.annotations.Test;
import patternmatching.set.Set;

import static org.testng.AssertJUnit.assertEquals;

public class TestSet {

    @Test
    public void testSets(){
        Set<String> set = new Set<>("hello", "hi", "hi");
        assertEquals(2, set.size());
        assertEquals(5, set.flatMap(CharFunctions::toSet).size());
    }

}
