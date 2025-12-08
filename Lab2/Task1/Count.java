import java.util.Scanner;

public class Count {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = "";
        while (sentence.isBlank()) {
            System.out.print("Enter a sentence: ");
            sentence = sc.nextLine().trim();
            if (sentence.isEmpty()) {
                System.out.println("Sentence cannot be empty. Please try again.");
            }
        }

        String word = "";
        while (word.isBlank()) {
            System.out.print("Enter the word to count: ");
            word = sc.nextLine().trim();
            if (word.isEmpty()) {
                System.out.println("Word cannot be empty. Please try again.");
            }
        }

        int count1 = countUsingSplit(sentence, word);
        int count2 = countUsingIndexOf(sentence, word);
        int count3 = countUsingReplaceAll(sentence, word);

        System.out.println("\nResults:");
        System.out.println("Using split: " + count1);
        System.out.println("Using indexOf: " + count2);
        System.out.println("Using replaceAll: " + count3);

        sc.close();
    }

    private static int countUsingSplit(String sentence, String word) {
        String[] words = sentence.split("\\W+"); 
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) { 
                count++;
            }
        }
        return count;
    }


    private static int countUsingIndexOf(String sentence, String word) {
        int count = 0;
        int index = 0;
        int wordLen = word.length();
        while ((index = sentence.indexOf(word, index)) != -1) {
            boolean startOK = index == 0 || !Character.isLetterOrDigit(sentence.charAt(index - 1));
            boolean endOK = index + wordLen == sentence.length() || !Character.isLetterOrDigit(sentence.charAt(index + wordLen));
            if (startOK && endOK) {
                count++;
            }
            index += wordLen;
        }
        return count;
    }

    private static int countUsingReplaceAll(String sentence, String word) {
        int originalLength = sentence.length();
        int newLength = sentence.replaceAll("(?i)\\b" + word + "\\b", "").length();
        return (originalLength - newLength) / word.length();
    }
}

