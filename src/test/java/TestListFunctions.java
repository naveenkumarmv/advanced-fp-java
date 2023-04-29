import patternmatching.list.LinkedList;
import patternmatching.list.List;
import patternmatching.list.None;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static patternmatching.list.ListFunctions.*;

public class TestListFunctions {
    @Test
    public void testMap(){
        List<Integer> list = testList();
        List<Integer> res = list.map(x -> x + 1);
        for(Integer i : res)
            System.out.println(i);

    }

    private static LinkedList<Integer> testList() {
        return new LinkedList<>(1, new LinkedList<>(2, new LinkedList<Integer>(3, new None<>())));
    }

    @Test
    public void testFold(){
        List<Integer> list = testList();
        assertEquals(fold(list,0, (x, y) -> x + y), 6);
    }

    @Test
    public void testFlatMap(){
        List<Integer> list = testList();
        List<Integer> lists = flatmap(list, TestListFunctions::twoList);
        assertEquals(size(lists), 6);
    }

    private static List<Integer> twoList(int i){
        return new LinkedList<>(i, new LinkedList<>(i + 1, new None<>()));
    }
}
