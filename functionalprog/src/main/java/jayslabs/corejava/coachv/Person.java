package jayslabs.corejava.coachv;

import java.util.List;

public record Person(String fname, String lname, List<String> emails) {
    public String fullName() {
        return fname + " " + lname;
    }

    public static final List<Person> SAMPLE_DATA = List.of(
        new Person("Anya", "Forger", List.of("anya1@forger.com")),
        new Person("Lloyd", "Forger", List.of("forger1@westalis.ws")),
        new Person("Yor", "Forger", List.of("forger2@ostania.os")),
        new Person("Bondo", "Forger", List.of("forger3@ostania.dog")),
        new Person("Becky", "Blackbell", List.of("becky@blackbell.com","becbec@ostania.com")),
        new Person("Damian", "Desmond", List.of("damian@ostania.com")),
        new Person("Maomao", "Meimei", List.of("Maomao@apotheca.ca"))

        );

}
