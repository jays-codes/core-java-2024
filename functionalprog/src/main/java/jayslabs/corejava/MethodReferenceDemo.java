package jayslabs.corejava;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<String> printer = System.out::println;
        names.forEach(printer);


        //sample of Bound method reference
        System.out.println("Using method reference:");
        names.forEach(System.out::println);
        

        names.forEach((name) -> System.out.println(name));

        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("Hello"));

    
    }
}
