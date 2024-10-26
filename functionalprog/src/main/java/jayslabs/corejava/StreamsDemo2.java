package jayslabs.corejava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamsDemo2 {
    public static void main(String[] args) {
        System.out.println("Streams Demo 2");
        //collectDemo();
        //collectDemo2();
        collectToMap();
        groupingByDemo1();
        groupingByDemo2();
        groupingByDemo3();
    }

    //collect demo - supplier, accumulator, combiner
    public static void collectDemo(){
        System.out.println("Collect demo");
        StringBuilder word = Stream.of("J", "a", "Doe", "y", "yow")
            .parallel()
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println("Word: " + word);

    }

    //collect demo - supplier, accumulator, combiner
    public static void collectDemo2(){
        System.out.println("Collect demo 2");

        //Collectors.joining()
        System.out.println("Collectors.joining() demo");
        String joined = Stream.of("J", "a", "Doe", "y", "yow")
            .parallel()
            .collect(Collectors.joining());
        System.out.println("Joined: " + joined);

        //Collectors.joining(delimiter)
        System.out.println("Collectors.joining(delimiter) demo");
        String[] abc = {"a", "b", "c"};
        String joined2 = Arrays.stream(abc).collect(Collectors.joining("-"));
        System.out.println("Joined2: " + joined2);

        //Collectors.averagingInt
        System.out.println("Collectors.averagingInt demo");
        
        double avg = Stream.of(1, 2, 3, 4, 5).collect(Collectors.averagingInt(i->i));
        //print input
        System.out.println("Input: " + Arrays.toString(new int[]{1, 2, 3, 4, 5}));
        
        System.out.println("Average: " + avg);
    }

    //Collectors.toMap demo
    public static void collectToMap(){
        System.out.println("Collectors.toMap demo");
        Map<String, Integer> map = Stream.of("a", "b", "c").collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Map: " + map);

        System.out.println("\nCollectors.toMap demo 2");
        String[] fruits = {"apple", "banana", "cherry"};
        System.out.println("Input: " + Arrays.toString(fruits));
        Map<String, String> map2 = Arrays.stream(fruits)
        .collect(Collectors.toMap(s->s, s->new StringBuilder(s).reverse().toString()));
        System.out.println("Output: " + map2);
        
        System.out.println("\nCollectors.toMap demo 3 - merge function");
        String[] pets = {"dog", "cat", "rat", "bird", "fish"};
        System.out.println("Input: " + Arrays.toString(pets));
        Map<Integer, String> map3 = Arrays.stream(pets)
            .collect(Collectors.toMap(String::length, s->s, (s1, s2)->s1+"|"+s2));
        System.out.println("Output: " + map3);

        System.out.println("\nCollectors.toMap demo 4 - merge function and supplier");
        String[] fruits2 = {"banana", "cherry", "apple"};
        System.out.println("Input: " + Arrays.toString(fruits2));
        Map<Integer, String> map4 = Arrays.stream(fruits2)
            .collect(Collectors.toMap(
                String::length, 
                s->s, 
                (s1, s2)->s1+"|"+s2, 
                TreeMap::new));
        System.out.println("Output: " + map4);
    }

    //Collectors.groupingBy demo
    public static void groupingByDemo1(){
        System.out.println("\nCollectors.groupingBy demo 1");
        String[] pets = {"dog", "cat", "rat", "bird", "fish", "dog"};
        System.out.println("Input: " + Arrays.toString(pets));
        Map<Integer, List<String>> map = Arrays.stream(pets)
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Output: " + map);
    }

    //Collectors.groupingBy demo - group by length of string; use set to avoid duplicates
    public static void groupingByDemo2(){
        System.out.println("\nCollectors.groupingBy demo 2");
        String[] pets = {"dog", "cat", "rat", "bird", "fish", "dog"};
        System.out.println("Input: " + Arrays.toString(pets));
        Map<Integer, Set<String>> map = Arrays.stream(pets)
            .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("Output: " + map);
    }

    //Collectors.groupingBy demo - group by length of string; 
    //use supplier to return a TreeMap
    public static void groupingByDemo3(){
        System.out.println("\nCollectors.groupingBy demo 3");
        String[] pets = {"dog", "cat", "rat", "bird", "fish", "dog"};
        System.out.println("Input: " + Arrays.toString(pets));
        Map<Integer, TreeSet<String>> map = Arrays.stream(pets)
            .collect(Collectors.groupingBy(
                String::length, 
                TreeMap::new, 
                Collectors.toCollection(TreeSet::new)
            )
        );
        System.out.println("Output: " + map);
    }
}
