package test.algebra;

import org.testng.annotations.Test;
import patternmatching.list.List;

import static test.TestHelper.testList;

public class TestAssociativity {

    @Test
    public void testFolds(){
        List<Integer> list = testList(4);
        System.out.println("result of left fold is " + list.foldL(100, (x, y) -> x - y));
        System.out.println("result of right fold is " + list.fold(100, (x, y) -> x - y));
    }
}
