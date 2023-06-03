package test.list;

import org.testng.annotations.Test;
import patternmatching.list.List;
import patternmatching.list.ListFunctions;

import static org.testng.Assert.assertEquals;
import static patternmatching.list.ListFunctions.*;
import static test.TestHelper.testList;

public class TestListFunctions {

    @Test
    public void testSize(){
        List<Integer> list = testList();
        assertEquals(size(list), 3);
    }

    @Test
    public void testCreation(){
        List<Integer> list = ListFunctions.list(1, 2, 3);
        assertEquals(size(list), 3);
    }

}
