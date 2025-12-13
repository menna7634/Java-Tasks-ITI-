public class Main {
    public static void main(String[] args) {
        SimpleWordDictionary dict = new SimpleWordDictionary();
        boolean running = true;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add word");
            System.out.println("2. Print all words");
            System.out.println("3. Print by letter");
            System.out.println("4. Search exact word");
            System.out.println("5. Statistics");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = InputUtils.readMenuChoice(1, 6);

            switch (choice) {
                case 1:
                    String word = InputUtils.readWord("Enter word: ");
                    dict.addWord(word);
                    break;

                case 2:
                    dict.printAll();
                    break;

                case 3:
                    char letter = InputUtils.readLetter("Enter letter: ");
                    dict.printByLetter(letter);
                    break;

                case 4:
                    String searchWord = InputUtils.readWord("Enter word to search: ");
                    dict.searchWord(searchWord);
                    break;

                case 5:
                    dict.printStatistics();
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
            }
        } while (running);
    }
}
