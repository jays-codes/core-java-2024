package jayslabs.corejava;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        System.out.println("Primitive Streams demo");
        
        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStrm = Arrays.stream(intArray);
        System.out.println("intStrm elements:");
        intStrm.forEach(System.out::println);

        //sum
        IntStream intStrm2 = Arrays.stream(intArray);
        int sum = intStrm2.sum();
        System.out.println("sum: " + sum);

        //average
        IntStream intStrm3 = Arrays.stream(intArray);
        double avg = intStrm3.average().getAsDouble();
        System.out.println("average: " + avg);

        //max
        IntStream intStrm4 = Arrays.stream(intArray);
        OptionalInt max = intStrm4.max();
        System.out.println("max: " + max.getAsInt());

        //min
        IntStream intStrm5 = Arrays.stream(intArray);
        OptionalInt min = intStrm5.min();
        System.out.println("min: " + min.getAsInt());

        //count
        IntStream intStrm6 = Arrays.stream(intArray);
        long count = intStrm6.count();
        System.out.println("count: " + count);

        //reduce
        IntStream intStrm7 = Arrays.stream(intArray);
        int product = intStrm7.reduce(1, (a, b) -> a * b);
        System.out.println("product: " + product);

        //summaryStatistics
        IntStream intStrm8 = Arrays.stream(intArray);
        IntSummaryStatistics stats = intStrm8.summaryStatistics();
        System.out.println("stats: " + stats);
    }
}
