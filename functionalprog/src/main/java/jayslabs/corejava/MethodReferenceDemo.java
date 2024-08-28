package jayslabs.corejava;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<String> printer = System.out::println;
        names.forEach(printer);

    }
}
