package jayslabs.corejava.coachv;

import java.util.List;
import java.util.stream.Collectors;

public class C4ComputingStatistics {
    public static void main(String[] args){

        //avgNumOfEmails();
        //avgNumOfEmails2();
        //avgNumOfEmails3();
        //totalNumOfEmails1();
        //listFirstNames();
        listEmails();
    }

    public static void avgNumOfEmails(){
        System.out.println(
            "emails per person: " +
            Person.SAMPLE_DATA.stream()
            .map(Person::emails)
            .mapToDouble(List::size)
            .sum() / Person.SAMPLE_DATA.size() *1.0

        );
    }

    public static void avgNumOfEmails2(){
        System.out.println(
            "emails per person: " +
            Person.SAMPLE_DATA.stream()
            .mapToDouble(p -> p.emails().size())
            .average()
            .orElse(0.0) // handle case where no persons
        );
    }

    public static void avgNumOfEmails3(){
        System.out.println(
            "emails per person: " +
            Person.SAMPLE_DATA.stream()
            .collect(
                Collectors.averagingDouble(p -> p.emails().size())
            ));
    }

    public static void totalNumOfEmails1(){
        System.out.println(
            "total emails: " +
            Person.SAMPLE_DATA.stream()
            .collect(
                Collectors.summarizingDouble(p -> p.emails().size())
            ));
    }

    public static void listFirstNames(){
        //var fnames = 
        Person.SAMPLE_DATA.stream().map(Person::fname)
        .toList().forEach(System.out::println);            
    }

    public static void listEmails(){
        Person.SAMPLE_DATA.stream()
        .flatMap(mapper -> mapper.emails().stream())
        .distinct()    
        .forEach(System.out::println);
    }
}
