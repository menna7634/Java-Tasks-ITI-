import java.util.*;

public class SimpleWordDictionary {
    private Map<Character, TreeSet<String>> wordsMap;

    public SimpleWordDictionary() {
        wordsMap = new TreeMap<>(); 
        for (char c = 'A'; c <= 'Z'; c++) {
            wordsMap.put(c, new TreeSet<>(String.CASE_INSENSITIVE_ORDER));
        }
    }

    public boolean addWord(String word) {
        if (!isValidWord(word)) return false;
        word = word.trim();
        char first = Character.toUpperCase(word.charAt(0));
        TreeSet<String> set = wordsMap.get(first);
        if (!set.add(word)) {
            System.out.println("Word already exists: \"" + word + "\"");
            return false;
        }
        System.out.println("Added \"" + word + "\" under '" + first + "'");
        return true;
    }

public void printAll() {
   System.out.println("\n--- ALL WORDS ---\n");
    wordsMap.forEach((letter, set) -> {
        if (!set.isEmpty()) {
            System.out.println(letter + ": " + set);
        }
    });
}

    
    public void printByLetter(char letter) {
        letter = Character.toUpperCase(letter);
        if (!Character.isLetter(letter)) {
            System.out.println("Invalid letter. Must be A-Z.");
            return;
        }
        TreeSet<String> set = wordsMap.get(letter);
        System.out.println("\nWords for " + letter + ":");

        if (set.isEmpty()) {
            System.out.println("No words found.");
        } else {
            set.forEach(w -> {
                System.out.println("- " + Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase());
            });
        }
    }

    public void searchWord(String word) {
        if (!isValidWord(word)) return;
        word = word.trim();
        char first = Character.toUpperCase(word.charAt(0));
        TreeSet<String> set = wordsMap.get(first);
        if (set.contains(word))
            System.out.println("✔ Word \"" + word + "\" found under '" + first + "'");
        else
            System.out.println("✘ Word \"" + word + "\" not found.");
    }

     public void printStatistics() {
    int totalWords = 0;
    char maxLetter = 'A';
    int maxCount = 0;
    List<Character> emptyLetters = new ArrayList<>();

    for (var entry : wordsMap.entrySet()) {
        int size = entry.getValue().size();
        totalWords += size;
        if (size == 0) 
            emptyLetters.add(entry.getKey());
        if (size > maxCount) {
            maxCount = size;
            maxLetter = entry.getKey();
        }
    }

    System.out.println("\n--- STATISTICS ---");
    System.out.println("Total words: " + totalWords);
    System.out.println("Letter with most words: " + maxLetter + " (" + maxCount + ")");
    System.out.println("Letters with no words: " + emptyLetters);
    System.out.println("--------------------\n");
}

    private boolean isValidWord(String word) {
        if (word == null || word.isBlank()) {
            System.out.println("Invalid input. Cannot be empty.");
            return false;
        }
        word = word.trim();
        char first = word.charAt(0);
        if (!Character.isLetter(first)) {
            System.out.println("Invalid input. Word must start with a letter.");
            return false;
        }
        return true;
    }
}
