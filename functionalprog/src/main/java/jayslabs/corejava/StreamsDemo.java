package jayslabs.corejava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        System.out.println("Stream Demo");

        //creatingStreams();
        //anymatchAndMapDemo();
        //lazinessDemo();
        //infiniteStreams();
        //infiniteStreamsUsingGenerate();
        streamVsForLoop();
    }

    // Creating Streams
    public static void creatingStreamsOld(){
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

    public static void creatingStreams(){
        //Arrays.stream()        
    }

    //create stream from a file
    public static void createStreamFromFile(){
        try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Infinite Streams using iterate
    public static void infiniteStreams(){
        Stream.iterate(2, n -> n + 2)
            .limit(10)
            .forEach(System.out::println);
    }

    //Infinite Streams using generate
    public static void infiniteStreamsUsingGenerate(){
        Stream.generate(Math::random)
            .limit(10)
            .forEach(System.out::println);
    }

    //stream vs for loop test of 100,000 ints. measure time taken
    public static void streamVsForLoop(){
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            ints.add(i);
        }

        //for loop
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < ints.size(); i++) {
            sum += ints.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("For loop time: " + (end - start));


        //stream
        start = System.currentTimeMillis();
        ints.stream()
            .mapToInt(Integer::intValue)
            .sum();
        end = System.currentTimeMillis();
        System.out.println("Stream time: " + (end - start));
        
        //optimized parallel stream
        start = System.currentTimeMillis();
        ints.parallelStream()
            .mapToInt(Integer::intValue)
            .sum();
        end = System.currentTimeMillis();
        System.out.println("Parallel stream time: " + (end - start));

        // Create an IntStream directly
        IntStream intStream = IntStream.range(0, 1000000);

        start = System.nanoTime();
        sum = intStream.parallel().sum();
        end = System.nanoTime();
        System.out.println("Optimized parallel stream time: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println("Sum: " + sum);
    }
}
