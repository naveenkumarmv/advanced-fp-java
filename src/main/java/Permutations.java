import algebra.CharFunctions;
import patternmatching.set.Set;

public class Permutations {
    public static Set<String> permutations(String s){
        return permutations(CharFunctions.toSet(s));
    }

    private static Set<String> permutations(Set<Character> characters) {
        return characters.flatMap(c -> {
            Set<Character> rest = characters.filter(ch -> !ch.equals(c));
            return rest.size() == 0 ? new Set<>(String.valueOf(c)) : permutations(rest).map(str -> c + str);
        });
    }

}
