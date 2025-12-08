import java.util.Arrays;
import java.util.Random;

public class BinaySearchArray {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No Arguments found");
            return;
        }

        String command = args[0].toLowerCase();
        int[] arr = new int[1000];
        Random rand = new Random();


        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }

        Arrays.sort(arr);

        if (command.equals("min")) {
            System.out.println("Minimum: " + arr[0]);
        } 
        else if (command.equals("max")) {
            System.out.println("Maximum: " + arr[arr.length - 1]);
        } 
        else if (command.equals("search")) {
                       if (args.length != 2) {
                System.out.println("You must enter search + number");
                return;
            }

            int target = Integer.parseInt(args[1]);
            int left = 0, right = arr.length - 1;
            boolean found = false;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == target) {
                    found = true;
                    break;
                }
                if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (found) {
                System.out.println(target + " found!");
            } else {
                System.out.println(target + " not found.");
            }
        } 
        else {
            System.out.println("Use only min, max, or search + number.");
        }
    }
}

