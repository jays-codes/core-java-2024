package jayslabs.corejava;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> times2 = (num) -> num * 2;
        System.out.println(times2.apply(5));

        //demo of BinaryOperator using strings
        BinaryOperator<String> concat = (str1, str2) -> str1 + str2;
        System.out.println(concat.apply("Hello, ", "World!"));
    }

}
