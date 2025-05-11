package jayslabs.corejava.coachv;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chap2ReusingLambdaExpressions {

    public static void main(String[] args) {
      
        //to filter name that starts with N
        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final Function<String, Predicate<String>> startsWithLetter = prefix -> name -> name.startsWith(prefix);

        //Brian, Nate, Neal, Raju, Sara, Scott
        final var friends = List.of("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
        //Brian, Jackie, John, Mike
        final var editors = List.of("Brian", "Jackie", "John", "Mike");

        //Kate, Ken, Nick, Paula, Zach
        final var comrades = List.of("Kate", "Ken", "Nick", "Paula", "Zach");

        // friends.stream()
        //     .filter(nm -> nm.startsWith("N"))
        //     .forEach(System.out::println);
      
        friends.stream()
            .filter(startsWith("N"))
            .forEach(System.out::println);

        editors.stream()
            .filter(startsWithLetter.apply("J"))
            .forEach(System.out::println);
    }


    public static Predicate<String> startsWith(String prefix) {
        return name -> name.startsWith(prefix);
    }
    //
}
