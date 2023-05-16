package list;

import org.testng.annotations.Test;
import patternmatching.list.List;

import static list.TestHelper.testList;
import static org.testng.Assert.assertEquals;
import static patternmatching.list.ListFunctions.*;

public class TestListFunctions {

    @Test
    public void testSize(){
        List<Integer> list = testList();
        assertEquals(size(list), 3);
    }
    @Test
    public void testEqual(){
        assertEquals(areEqual(testList(), testList()), true);
    }


}
