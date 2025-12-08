public class Test {
    public static void main(String[] args) {
        Thrower t = new Thrower();

        try {
            t.first();
            t.second();
            t.third();
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("in finally");
        }

        System.out.println("outside try catch and finally");
    }
}
