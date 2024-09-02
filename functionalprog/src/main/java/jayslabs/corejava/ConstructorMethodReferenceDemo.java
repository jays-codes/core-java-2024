package jayslabs.corejava;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorMethodReferenceDemo {
    public static void main(String[] args) {
        //constructor reference
        Supplier<String> supplier = String::new;
        System.out.println(supplier.get());

        //constructor reference using StringBuilder
        String name = "Jay";
        Function<String, StringBuilder> function = StringBuilder::new;
        System.out.println(function.apply("Hello ").append(name));
    }
}
