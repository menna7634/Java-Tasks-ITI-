import java.util.StringTokenizer;

public class ITITokens {
    public static void main(String[] args) {
        String sentence = "ITI develops people and ITI house of developers and ITI for people";

        System.out.println("Using StringTokenizer :");
        StringTokenizer tokenizer = new StringTokenizer(sentence, "ITI");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                System.out.println(token);
            }
        }

        System.out.println("\nUsing String.split() :");
        String[] tokensSplit = sentence.split("ITI");
        for (String token : tokensSplit) {
            token = token.trim();
            if (!token.isEmpty()) {
                System.out.println(token);
            }
        }

    }
}

