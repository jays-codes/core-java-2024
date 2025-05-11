package jayslabs.corejava.coachv;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Chap2ReducingCollection {
    public static void main(String[] args) {

        final var friends = List.of("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final var editors = List.of("Brian", "Jackie", "John", "Mike");
        final var comrades = List.of("Kate", "Ken", "Nick", "Paula", "Zach");
        

        System.out.println("Total length of names: " +
        comrades.stream().mapToInt(name -> name.length())
            .sum());

        final Optional<String> longestName = comrades.stream()
            .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        

        final Optional<String> longestName2 = comrades.stream()
        .max(Comparator.comparing(String::length));

        longestName.ifPresent(name -> 
            System.out.println("Longest name: " + name)
        );

        var longestName3 = comrades.stream()
            .reduce("Ken", (name1, name2) -> name1.length() > name2.length() ? name1 : name2);
    
        System.out.println("Longest name 3: " + longestName3);
    }
}   