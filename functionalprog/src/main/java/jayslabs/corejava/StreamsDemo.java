package jayslabs.corejava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BinaryOperator;
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
        //streamVsForLoop();
        //minMaxDemo();
        //findAnyAndFindFirstDemo();
        //forEachDemo();
        //reduceDemo();
        collectDemo();
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

    //only charlie reached the last for each because 
    //it's the only element that passed all the filters
    public static void lazinessDemo(){
        System.out.println("Laziness demo");
        List<String> names = Arrays.asList("April", "Ben", "Charlie", "David", "Benildus", "Christian");

        names.stream()
            .peek(n->System.out.println("Peek: " + n))
            .filter(name -> {
                System.out.println("Filter1: " + name);
                return name.startsWith("B") || name.startsWith("C");
            })
            .filter(s -> {
                System.out.println("Filter2: " + s);
                return s.length() > 3;
            })
            .limit(1)
            .forEach(f->System.out.println("For Each: " + f));
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
        int size = 100000;
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < size; i++) {
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

    public static void minMaxDemo(){
        System.out.println("Min Max demo");
        System.out.println("Min Max demo - ints");

        //generate a list of 10 random ints between 1 and 100   
        List<Integer> ints = new Random().ints(10, 1, 100).boxed().toList();
        //print the list
        System.out.println(ints);

        Optional<Integer> min = ints.stream().min(Integer::compare);
        Optional<Integer> max = ints.stream().max(Integer::compare);
        
        min.ifPresent(System.out::println);
        max.ifPresent(System.out::println);

        System.out.println("Min Max demo - strings");
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon");
        Optional<String> minString = strings.stream().min((c1, c2) -> c1.length() - c2.length());
        Optional<String> maxString = strings.stream().max((c1, c2) -> c1.length() - c2.length());
        
        minString.ifPresent(System.out::println);
        maxString.ifPresent(System.out::println);
    }

    public static void findAnyAndFindFirstDemo(){
        System.out.println("Find Any and Find First demo");
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon");
        Optional<String> any = strings.stream().findAny();
        Optional<String> first = strings.stream().findFirst();
        any.ifPresent(x -> anyProcessor(x));
        first.ifPresent(System.out::println);
    }

    public static void anyProcessor(String str){
        System.out.println("Any processor demo");
        System.out.println("String: " + str);
        String reversed = reverseString(str);
        System.out.println("Reversed: " + reversed);

    }

    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static void forEachDemo(){
        System.out.println("For Each demo");
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon");
        //strings.forEach(nm -> System.out.println(nm + " " + reverseString(nm)));
        System.out.println("For Each demo list: " + strings);

        System.out.println("Stream For Each demo");
        List<String> reversedList = new ArrayList<>();
        strings.stream()
            .forEach(nm -> {
                reversedList.add(reverseString(nm));
                System.out.println(nm + " " + reverseString(nm));
        });
        System.out.println("Reversed List: " + reversedList);
    }

    public static void reduceDemo(){
        System.out.println("Reduce demo");
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = ints.stream().reduce(0, (a, b) -> a + (b*b) );
        System.out.println("Sum: " + sum);

        System.out.println("Reduce demo - strings");
        String name = Stream.of("J", "a", "Doe", "y", "yow")
            .filter(ch -> ch.length() == 1)
            .peek(System.out::println)
            .reduce("", (a, b) -> a + b);
        System.out.println("Name: " + name);

        System.out.println("Reduce demo - binary operator");
        BinaryOperator<Integer> adder = (a, b) -> a + b;  
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(1, 2, 3);

        empty.reduce(adder).ifPresent(System.out::println);
        oneElement.reduce(adder).ifPresent(System.out::println);
        threeElements.reduce(adder).ifPresent(System.out::println);

        System.out.println("\nReduce demo - identity, accumulator, combiner");
        //example below executes reduce method on a stream of words
        //and returns the total number of characters in all the words
        List<String> words = Arrays.asList("Hello", "World", "Java", "Streams");
        int totalChars = words.stream()
            .parallel().reduce(0, (acc, word) -> acc + word.length(), (a, b) -> a + b);
        System.out.println("Total characters: " + totalChars);
    }

    public static void collectDemo(){
        System.out.println("Collect demo");
        StringBuilder word = Stream.of("J", "a", "Doe", "y", "yow")
            .parallel()
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println("Word: " + word);

    }
}
