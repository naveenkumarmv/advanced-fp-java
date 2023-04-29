package patternmatching.example;

import static patternmatching.example.Ternary.*;

public class TernaryUtil {
    public static Ternary plusOneModThree(Ternary t){
        return switch(t){
            case ONE -> TWO;
            case TWO -> THREE;
            case THREE -> ONE;
        };
    }
}
