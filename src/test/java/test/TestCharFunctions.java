package test;

import algebra.CharFunctions;
import org.testng.annotations.Test;
import patternmatching.set.Set;

import static org.testng.Assert.assertEquals;

public class TestCharFunctions {

    @Test
    public void testToSet(){
        Set<Character> set = CharFunctions.toSet("hello");
        assertEquals(4, set.size());
    }
}
