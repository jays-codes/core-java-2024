
package jayslabs.corejava;

import java.util.function.BiPredicate;
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

        System.out.println(check(str, isPalindrome));
        System.out.println(check(-78, i -> i < 0));

        System.out.println("Bi Predicate demo");
        BiPredicate<String, String> startsWith = (str2, prfx) -> str2.startsWith(prfx);
        System.out.println("startsWith: " + startsWith.test("Hello", "H"));

        System.out.println("\nBiPredicate demo via generic method");
        System.out.println("check length: " + check("Hello", 5, (str3, len) -> str3.length() == len));
    }

    public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }

    //generic method for BiPredicate
    public static <T, U> boolean check(T t, U u, BiPredicate<T, U> lambda){
        return lambda.test(t, u);
    }
}