package jayslabs.corejava.coachv;

import java.util.stream.Collectors;

public class C4FlatMappingAndFilteringTeeing {

    public static void main(String[] args) {
        //groupByLastNameWithComEmails();
        //groupByLastNameWithComEmails2();
        teeing();
    }

    // //group person based on their last name and selective store as value, their emails ending in ".com"
    // public static void groupByLastNameWithComEmails() {
    //     var results = Person.SAMPLE_DATA.stream()
    //     .collect(Collectors.groupingBy(Person::lname,
    //         Collectors.flatMapping(
    //             p -> p.emails().stream(),
    //                 Collectors.filtering(email -> email.endsWith(".com"), 
    //                 Collectors.toList()
    //         ))));
    // }

    public static void groupByLastNameWithComEmails2() {
        var lastNamesAndEmailAddressesFiltered = Person.SAMPLE_DATA.stream()
            .collect(Collectors.groupingBy(Person::lname,
                Collectors.flatMapping(
                    person -> person.emails().stream(),
                    Collectors.filtering(address -> address.endsWith(".com"), 
                    Collectors.toList()
                    ))));
        
        System.out.println(lastNamesAndEmailAddressesFiltered);
    }

    public static void teeing(){
        //teeing is a terminal operation that combines two results into one
        var teeingResult = Person.SAMPLE_DATA.stream()
            .collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.averagingInt(Person::age),
                (count, totalAge) -> "Count: " + count + ", Total Age: " + totalAge
            ));

        System.out.println(teeingResult);
    }
    
}
