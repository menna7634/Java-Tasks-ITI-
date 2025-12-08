public class StringChecker {

   
    public static boolean OnlyAlphabets(String str) {
        
        if (str == null || str.isEmpty()) {
            return false; 
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
             if (!Character.isLetter(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        String test1 = "menna";
        String test2 = "Menna123";
        String test3 = "menna Mohamed";
        String test4 = "-";
        
        System.out.println("'" + test1 + "' contains only alphabets: " + OnlyAlphabets(test1)); 
        System.out.println("'" + test2 + "' contains only alphabets: " + OnlyAlphabets(test2)); 
        System.out.println("'" + test3 + "' contains only alphabets: " + OnlyAlphabets(test3)); 
        System.out.println("'" + test4 + "' contains only alphabets: " + OnlyAlphabets(test4)); 
    }
}