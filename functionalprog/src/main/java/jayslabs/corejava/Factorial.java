package jayslabs.corejava;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Factorial of 8 is: " + iterfactorial(8));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int iterfactorial(int n){
        int result = 1;
        
        for (int i=1; i<=n;i++){
            result = result *i;
        }

        return result;
    }
}
