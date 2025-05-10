package jayslabs.corejava.coachv;

import java.util.List;

public class Chap2 {

    public static void main(String[] args){
        final var friends = List.of("John", "Jane", "Jim", "Jill", "Jack", "Jenny", "Jake", "Jill", "Jack", "Jill");
    
        //System.out.println("Friends: " + friends);

        //BP: functional iteration
        friends.forEach(name -> System.out.println(name));
        //friends.forEach(System.out::println);
        
        //BP: modifying a list        
        friends.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);

        //BP: print all names and uppercase only names with length not equal to 4    
        System.out.println("\nAll names (with names length != 4 in uppercase):");  
        friends.stream()
            .map(name -> name.length() != 4 ? name.toUpperCase() : name)
            .forEach(System.out::println);

        //avg of all integers
        var nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var avg = nums.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);

        System.out.println("\nAverage of all integers: " + avg);
        
        //use filter()
        friends.stream()
            .filter(name -> name.length() != 4)
            .forEach(System.out::println);

        System.out.println("using dropWhile()");
        //dropWhile
        friends.stream()
            .dropWhile(name -> name.length() != 4)
            .map(String::toUpperCase)
            .forEach(System.out::println);

        //takeWhile
        System.out.println("\nusing takeWhile()");
        friends.stream().limit(2)
        .takeWhile(name -> name.length() != 5)
        .map(String::toUpperCase)
        .forEach(System.out::println);
    }
}
