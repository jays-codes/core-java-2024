package jayslabs.corejava;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<String> printer = System.out::println;
        names.forEach(printer);

        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("Hello"));

        //sample of Unbound method reference
        




        //another sample of bound method reference
        String prefix = "Hello";
        Supplier<Integer> lenSupplier = prefix::length;
        System.out.println(lenSupplier.get());

    }
}
