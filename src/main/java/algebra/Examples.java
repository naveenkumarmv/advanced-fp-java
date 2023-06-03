package algebra;

import patternmatching.list.List;

import static algebra.CharFunctions.isVowel;

public class Examples {

    public static <E> int size(List<E> list){
        return list.match(0, (head, tail) -> 1 + size(tail));
    }

    public static int countStartsWithVowels(List<String> list){
        return list.match(0, (head, tail) -> isVowel(head.charAt(0))? 1: 0 + countStartsWithVowels(tail));
    }

}
