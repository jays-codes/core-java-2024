package jayslabs.corejava;

import java.util.Optional;

public class OptionalsDemo {
    public static void main(String[] args) {
        System.out.println("Optionals Demo");
        optionalDemo();
    }

    public static void optionalDemo(){
        System.out.println("OptionalDemo()");

        // Creating an Optional
        Optional<String> optional = Optional.of("Hello");  // Non-empty Optional
        Optional<String> emptyOptional = Optional.empty(); // Empty Optional
        Optional<String> nullableOptional = Optional.ofNullable(null); // Can be null

        // Accessing the value
        String value = optional.get(); // Returns "Hello"
        String defaultValue = emptyOptional.orElse("Default"); // Returns "Default"

        // Using ifPresent
        optional.ifPresent(System.out::println); // Prints "Hello"

        // Using map
        Optional<Integer> length = optional.map(String::length); // Maps to Optional<Integer> with value 5

        // Using flatMap
        Optional<String> upperCase = optional.flatMap(s -> Optional.of(s.toUpperCase())); // "HELLO"

        // Using filter
        Optional<String> filtered = optional.filter(s -> s.startsWith("H")); // Optional with "Hello"

        //using ofNullable
        Optional<String> ofNullable = Optional.ofNullable(null); // Optional with null

    }
}
