package jayslabs.corejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class ParallelStreams {
    public static void main(String[] args) {
        System.out.println("Parallel Streams");
        parallelStreamsDemo();
    }

    public static void parallelStreamsDemo(){
        System.out.println("ParallelStreamsDemo()");

        List<String> names = 
            Arrays.asList("John", "Jane", "Jim", "Jill", 
            "Jack", "Jenny", "Jake", "Jill", "Jack", "Jill");

        names.parallelStream().forEach(System.out::println);

        //parallel() demo
        List<String> names2 = 
            Arrays.asList("John", "Jane", "Jim", "Jill", 
            "Jack", "Jenny", "Jake", "Jill", "Jack", "Jill");

        names2.stream().parallel().forEach(System.out::println);

        //return sum of 100,000 integers from 1 to 100,000
        long sum = LongStream.rangeClosed(1, 100_000).parallel().sum();
        System.out.println("Sum: " + sum);

        //format sum with commas
        System.out.println("Sum: " + String.format("%,d", sum));
    }
}
