package jayslabs.corejava;

import java.util.function.Predicate;

interface Ilambda{
    void lambda();
}

//Predicate
interface ILambPredicate<T>{
    boolean test(T t);
}

public class LambdaHworld {
    public static void main(String[] args) {
        Ilambda lambda = () -> System.out.println("Yeaaaaoooowww!!! HWorld !!!");
        lambda.lambda();

        ILambPredicate<Integer> isNega = i -> i < 0;
        System.out.println(isNega.test(-1));

        Predicate<String> isPalindrome = str -> {
            String rev = new StringBuilder(str).reverse().toString();
            return str.equals(rev);
        };

        String str = "madam1";
        System.out.println(str + " <-- isPalindrome?: " + isPalindrome.test(str));
    }
}
