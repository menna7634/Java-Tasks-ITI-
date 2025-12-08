public class StringCheck {

    public static String betterString(String s1, String s2, TwoString predicate) {
        if (predicate.check(s1, s2)) {
            return s1; 
        } else {
            return s2; 
        }
    }
}