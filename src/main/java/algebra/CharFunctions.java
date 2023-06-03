package algebra;

import patternmatching.set.Set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CharFunctions {
    public static boolean isVowel(char c){
        return isLowercaseVowel(c) || isUppercaseVowel(c);
    }

    static boolean isLowercaseVowel (char c)
    {
        // returns 1 if char matches any of below
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    static boolean isUppercaseVowel (char c)
    {
        // returns 1 if char matches any of below
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
    public static Set<Character> toSet(String s){
        List<Character> list = s.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toList());
        Set<Character>set = new Set(list);
        return set;
    }
}
