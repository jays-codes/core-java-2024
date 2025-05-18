package jayslabs.corejava.coachv;

import java.util.List;
import java.util.stream.Collectors;

public class Chap2JoiningElements {

    public static void main(String[] args) {
        final var friends = List.of("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final var editors = List.of("Brian", "Jackie", "John", "Mike");
        final var comrades = List.of("Kate", "Ken", "Nick", "Paula", "Zach");

        //BP: joining elements
        // String joinedNames = friends.stream()
        //         .map(String::toUpperCase)
        //         .reduce("", (name1, name2) -> name1 + ", " + name2);

        // System.out.println("Joined names: " + joinedNames);
    
        //System.out.println(String.join(",", friends));

        System.out.println(
            editors.stream().map(String::toUpperCase)
            .collect(Collectors.joining(", ")));

    }
}
