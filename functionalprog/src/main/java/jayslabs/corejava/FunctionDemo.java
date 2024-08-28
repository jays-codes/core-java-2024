package jayslabs.corejava;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> strLength = (str) -> str.length();
        System.out.println(strLength.apply("Hello, World!"));
    
        //demo of andThen
        Function<Integer, Integer> times2 = (num) -> num * 2;
        Function<Integer, Integer> minus1 = (num) -> num - 1;
        Function<Integer, Integer> times2AndMinus1 = times2.andThen(minus1);
        System.out.println(times2AndMinus1.apply(5));

        //demo of compose
        Function<Integer, Integer> composetimes2AndMinus1 = minus1.compose(times2);
        System.out.println(composetimes2AndMinus1.apply(5));

        //demo of using andThen with BiFunctions
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> multiplyBy2 = (num) -> num * 2;
        BiFunction<Integer, Integer, Integer> addAndMultiplyBy2 = add.andThen(multiplyBy2);
        System.out.println(addAndMultiplyBy2.apply(5, 5));
    }
}
