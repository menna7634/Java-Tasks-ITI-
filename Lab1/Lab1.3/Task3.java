public class Task3 {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Provide a number and a string.");
            return;
        }


        String numStr = args[0];

        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) < '0' || numStr.charAt(i) > '9') {
                System.out.println("Invalid number: " + numStr);
                return;
            }
        }

        int number = 0;
        for (int i = 0; i < numStr.length(); i++) {
            number = number * 10 + (numStr.charAt(i) - '0');
        }

        String text = args[1];
        for (int i = 2; i < args.length; i++) {
            text += " " + args[i];
        }

        System.out.println("Number: " + number);
        System.out.println("Text: " + text);
    }
}

