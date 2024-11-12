package jayslabs.corejava;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo3_IntermediateOps {
    public static void main(String[] args) {
        System.out.println("Streams Demo - Intermediate Operations");

        //filter
        //filterDemo();
        //distinctDemo();
        //limitDemo();
        //mapDemo();
        //flatMapDemo();
        sortedDemo();
    }

    public static void filterDemo(){
        System.out.println("\nfilter demo");
        System.out.println("Input: " + Arrays.toString(new String[]{"a", "bb", "ccc", "dd", "ee", "f"}));
        Stream.of("a", "bb", "ccc", "dd", "ee", "f")
        .filter(s->s.length()>2)
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
        .filter(s->s.length()>1)
        .limit(1)
        .forEach(System.out::println);
    }

    public static void mapDemo(){
        System.out.println("\nmap demo");
        System.out.println("Input: " + Arrays.toString(new String[]{"a", "bb", "ccc", "dd", "ee", "f"}));
        Stream.of("a", "bb", "ccc", "dd", "ee", "f")
        .map(s->s.length())
        .forEach(System.out::println);
        }

    public static void flatMapDemo(){
        System.out.println("\nflatMap demo");
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1, 2), 
            Arrays.asList(3, 4)
        );

        List<Integer> flatList = nestedList.stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());

        System.out.println("Input: " + nestedList);
        System.out.println("Output: " + flatList);

        System.err.println("\n\ntester x");
        Integer x = 128;
        Integer y = 128;
        System.out.println("x==y: " + (x==y));

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println("s1.equals(s2) " + (s1.equals(s2)));
        System.out.println("s1==s2 " + (s1==s2));
    }

    /**
      
    class Product {
        private List<Category> categories;
        private List<Tag> tags;
        // getters...
    }

    // Get unique tags across all products in specific categories
    Set<String> uniqueTags = products.stream()
        .flatMap(product -> product.getCategories().stream())
        .filter(category -> category.isActive())
        .flatMap(category -> category.getProducts().stream())
        .flatMap(product -> product.getTags().stream())
        .map(Tag::getName)
        .collect(Collectors.toSet()); 
    
        
     */

    public static void sortedDemo(){
        System.out.println("\nsorted demo");
        Stream.of("a", "x", "y", "f", "ccc", "dd", "ee", "bb")
        .sorted()
        .forEach(System.out::println);
    }
}


