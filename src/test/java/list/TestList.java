package list;

import patternmatching.list.LinkedList;
import patternmatching.list.List;
import patternmatching.list.None;
import org.testng.annotations.Test;

import static list.TestHelper.testList;
import static org.testng.Assert.assertEquals;
import static patternmatching.list.ListFunctions.*;

public class TestList {


    @Test
    public void testMap(){
        List<Integer> list = testList();
        List<Integer> res = list.map(x -> x + 1);
        for(Integer i : res)
            System.out.println(i);

    }

    @Test
    public void testFold(){
        List<Integer> list = testList();
        assertEquals(list.fold(0, (x, y) -> x + y), 6);
    }

    @Test
    public void testFlatMap(){
        List<Integer> list = testList();
        List<Integer> lists = list.flatmap(TestList::twoList);
        assertEquals(size(lists), 6);
    }

    private static List<Integer> twoList(int i){
        return new LinkedList<>(i, new LinkedList<>(i + 1, new None<>()));
    }
}
