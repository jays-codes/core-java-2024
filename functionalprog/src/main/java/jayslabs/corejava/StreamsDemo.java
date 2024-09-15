package jayslabs.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo {
    public static void main(String[] args) {
        System.out.println("Stream Demo");

        //creatingStreams();
        //anymatchAndMapDemo();
        lazinessDemo();
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

    //anymatch and map in a single streamdemo
    public static void anymatchAndMapDemo(){
        System.out.println("Anymatch and map demo");
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Doe");

        boolean anyMatch = names.stream()
            .map(String::toUpperCase)  //map to uppercase
            .anyMatch(name -> name.startsWith("J"));
        System.out.println("Any match: " + anyMatch);
    }

    public static void lazinessDemo(){
        System.out.println("Laziness demo");
        List<String> names = Arrays.asList("April", "Ben", "Charlie", "David", "Benildus", "Christian");

        names.stream()
            .peek(System.out::println)
            .filter(name -> {
                System.out.println("Filter1: " + name);
                return name.startsWith("B") || name.startsWith("C");
            })
            .filter(s -> {
                System.out.println("Filter2: " + s);
                return s.length() > 3;
            })
            .limit(1)
            .forEach(System.out::println);
    }


}
