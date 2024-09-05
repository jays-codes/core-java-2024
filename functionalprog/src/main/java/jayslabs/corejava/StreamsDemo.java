package jayslabs.corejava;

import java.util.ArrayList;
import java.util.List;

public class StreamsDemo {
    public static void main(String[] args) {
        System.out.println("Stream Demo");

        creatingStreams();
    }

    

    // Creating Streams
    public static void creatingStreams(){
        System.out.println("Names");
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Doe");

        System.out.println("filter demo");
        
        long count = names.stream()
                    .peek(System.out::println)
                    .filter(name -> name.startsWith("J"))
                    .peek(System.out::println)
                    .count();
        System.out.println("Number of names after filter: " + count);
    }
}
