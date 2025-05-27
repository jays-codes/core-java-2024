package jayslabs.corejava.coachv;

import java.util.List;

public record Person(String fname, String lname, int age, List<String> emails) {
    public String fullName() {
        return fname + " " + lname;
    }

    public static final List<Person> SAMPLE_DATA = List.of(
        new Person("Anya", "Forger", 7,List.of("anya1@forger.com")),
        new Person("Lloyd", "Forger", 28,List.of("forger1@westalis.ws")),
        new Person("Yor", "Forger", 26, List.of("forger2@ostania.os")),
        new Person("Bondo", "Forger", 4, List.of("forger3@ostania.dog")),
        new Person("Becky", "Blackbell", 8, List.of("becky@blackbell.com","becbec@ostania.com")),
        new Person("Damian", "Desmond", 8, List.of("damian@ostania.com")),
        new Person("Maomao", "Meimei", 17, List.of("Maomao@apotheca.ca"))

        );

}
