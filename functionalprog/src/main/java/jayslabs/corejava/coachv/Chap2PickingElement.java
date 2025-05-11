package jayslabs.corejava.coachv;

import java.util.List;
import java.util.Optional;


public class Chap2PickingElement {

    public static void main(String[] args) {

        final var friends = List.of("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final var editors = List.of("Brian", "Jackie", "John", "Mike");
        final var comrades = List.of("Kate", "Ken", "Nick", "Paula", "Zach");

        pickName(comrades, "S");

    }

    public static void pickNameTrad(
        final List<String> names,
        final String startingLetter
    ){
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }

        System.out.print(String.format("Name starting with %s: ", startingLetter));

        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    public static void pickName(
        final List<String> names,
        final String startingLetter
    ){
        final Optional<String> foundName = 
        names.stream()
            .filter(name -> name.startsWith(startingLetter))
            .findFirst();
        
        System.out.print(
            String.format("Name starting with %s: %s ", 
            startingLetter, 
            foundName.orElse("No name found")
        ));
    }
}
