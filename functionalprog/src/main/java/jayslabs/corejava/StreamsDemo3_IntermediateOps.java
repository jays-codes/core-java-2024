package jayslabs.corejava;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsDemo3_IntermediateOps {
    public static void main(String[] args) {
        System.out.println("Streams Demo - Intermediate Operations");

        //filter
        //filterDemo();
        //distinctDemo();
        limitDemo();
    }

    public static void filterDemo(){
        System.out.println("\nfilter demo");
        System.out.println("Input: " + Arrays.toString(new String[]{"a", "bb", "ccc", "dd", "ee", "f"}));
        Stream.of("a", "bb", "ccc", "dd", "ee", "f")
        .filter(s->s.length()>1)
        .forEach(System.out::println);
    }

    public static void distinctDemo(){
        System.out.println("\ndistinct demo");
        System.out.println("Input: " + Arrays.toString(new String[]{"a", "bb", "ccc", "dd", "ee", "f", "ccc", "dd"}));
        Stream.of("a", "bb", "ccc", "dd", "ee", "f", "ccc", "dd", "DD")
        .distinct()
        .forEach(System.out::println);
    }

    public static void limitDemo(){ 
        System.out.println("\nlimit demo");
        System.out.println("Input: " + Arrays.toString(new String[]{"a", "bb", "ccc", "dd", "ee", "f", "ccc", "dd"}));
        Stream.of("a", "bb", "ccc", "dd", "ee", "f", "dcc", "dd")
        .filter(s->s.length()>2)
        .limit(1)
        .forEach(System.out::println);
    }
}
