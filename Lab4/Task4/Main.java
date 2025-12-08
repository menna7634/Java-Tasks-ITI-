public class  Main {
    public static void main(String[] args) {
        String string1 = "String1";
        String string2 = "String22222";

        String longer = StringCheck.betterString(string1, string2, 
                            (s1, s2) -> s1.length() > s2.length());
        
        System.out.println("String 1: " + string1 + ", Length: " + string1.length());
        System.out.println("String 2: " + string2 + ", Length: " + string2.length());
        System.out.println("The longer string is: " + longer); 
        
        System.out.println("---");

        String first = StringCheck.betterString(string1, string2, 
                           (s1, s2) -> true);
                           
        System.out.println("The 'first' string is: " + first); 
    }
}