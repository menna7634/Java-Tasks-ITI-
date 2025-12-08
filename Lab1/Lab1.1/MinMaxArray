import java.util.Random;

public class MinMaxArray {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();


        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
         for (int i=0 ; i<arr.length ; i++){
                 System.out.println("The Number in index "+ i + " = " + arr[i]);
         }

        long start = System.nanoTime();

        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) {
            min = num;
            }
            if (num > max) {
            max = num;
            }
        }

        long end = System.nanoTime();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Running time (ns): " + (end - start));
    }
}

