package jayslabs.corejava;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        //primitive streams demo
        System.out.println("Primitive Streams demo");
        
        //streamsDemo1();
        primitiveStreamsBestPractice();
        commonUseCases();


    }

    public static void streamsDemo1() {
        System.out.println("Streams Demo 1");

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

    public static void primitiveStreamsBestPractice() {
        System.out.println("Primitive Streams Best Practice");

        // Good practice
        List<User> users = IntStream.rangeClosed(1, 5)
            .mapToObj(User::new)
            .collect(Collectors.toList());
        System.out.println("users: " + users);

        // 2. Use specific primitive streams for better performance
        
        // Instead of this (boxing/unboxing overhead)
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println("stream: " + stream);
        // Use this
        IntStream intStream = IntStream.rangeClosed(1, 5);
        System.out.println("intStream: " + intStream);

        // 3. Use parallel streams for large datasets
        long sum = IntStream.rangeClosed(1, 1_000_000)
            .parallel()
            .sum();
        System.out.println("sum: " + sum);
    }


    public static void commonUseCases() {
        System.out.println("Common Use Cases");

        //1. Generate a stream of random numbers
        // ThreadLocalRandom is a class that provides a random number generator that is specific to the current thread.
        System.out.println("Generating a stream of random numbers");
        IntStream randomNumbers = ThreadLocalRandom
        .current().ints(5, 100, 200);
        System.out.println("randomNumbers: " + randomNumbers);

        //2. Pagination
        // Paginate a list of records
        System.out.println("Paginating a list of records");
        // create a list of records
        List<Record> records = Arrays.asList(
            new Record(1), 
            new Record(2), 
            new Record(3), 
            new Record(4), 
            new Record(5));

        List<Record> pagedRecords = getPagedRecords(records, 10, 2);
        System.out.println("pagedRecords: " + pagedRecords);
    }

    // Paginate a list of records; 
    //page is 0-based index; size is number of records per page
    public static List<Record> getPagedRecords(List<Record> records, int page, int size) {
        return IntStream.range(0, records.size())
            .filter(i -> i >= page * size && i < (page + 1) * size)
            .mapToObj(records::get)
            .collect(Collectors.toList());
    }
}

// 1. Use mapToObj when converting to objects
class User {
    private int id;
    public User(int id) { this.id = id; }
}

class Record {
    private int id;
    public Record(int id) { this.id = id; }
}

