package jayslabs.corejava.coachv;

import java.util.stream.Collectors;

public class C4PartitioningCollections {

    public static void main(String[] args) {
        //testPartitioningBy();
        testGroupingBy();
    }

    public static void testPartitioningBy() {
        // Partitioning by emails count
        var partitioned = Person.SAMPLE_DATA.stream()
            .collect(Collectors.partitioningBy(
                p -> p.lname().startsWith("F")
            ));

        System.out.println("Persons with F:");
        partitioned.get(true).forEach(p -> System.out.println(p.fullName()));

        System.out.println("Persons that doesnt starts with F");
        partitioned.get(false).forEach(p -> System.out.println(p.fullName()));
    }

    public static void testGroupingBy() {
        //count occurences of first names
        var grouped = Person.SAMPLE_DATA.stream() 
            .collect(Collectors.groupingBy(
                Person::lname,
                Collectors.counting()
            ));

        System.out.println(grouped);
    }
}
