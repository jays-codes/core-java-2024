package jayslabs.corejava;

public class Fibonacci {
    public static void main(String[] args) {
        

        System.out.println("Fibonacci of 15 is: ");
        fibonacci(15);
    }

    public static void fibonacci(int n){
        int[] fib = new int[n+1];

        fib[0] = 0;
        fib[1] = 1;

        for (int i=2;i < fib.length;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        //use method reference to print the array
        java.util.Arrays.stream(fib).forEach(System.out::println);

    }
}
