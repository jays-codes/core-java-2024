package jayslabs.corejava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import jayslabs.corejava.entity.Person;

public class LambdasAssignment {
    public static void main(String[] args) {
        Printable<String> printer = (str) -> System.out.println(str);
        printer.consumer("Jay");

        System.out.println("Printer 2 - Consumer");
        Consumer<String> printer2 = System.out::println;
        printer2.accept("Jay2");

        Retrievable<Integer> supply77 = () -> 77;
        System.out.println(supply77.supplier());

        System.out.println("Supplier");
        Supplier<Integer> supplyer77 = () -> 77;
        System.out.println(supplyer77.get());

        Evaluate<Integer> isNega = (i) -> i<0;
        System.out.println(isNega.predicate(-1));
        System.out.println(isNega.predicate(1));

        Predicate<Integer> isNegativ = i -> i<0;
        System.out.println(isNegativ.test(-1));
        System.out.println(isNegativ.test(1));

        Predicate<Integer> isEven = i -> i%2 == 0;
        System.out.println(check(4, isEven));
        System.out.println(check(7, isEven));

        Predicate<String> beginsWithMr = str -> str.startsWith("Mr.");
        System.out.println(check("Mr. Jay", str -> str.startsWith("Mr.")));
        System.out.println(check("Ms. Jay", beginsWithMr));

        System.out.println("Check age");
        System.out.println(check(33, age -> age >=18));
        System.out.println(check(13, age -> age >=18));

        System.out.println("Append number");
        Functionable<Integer, String> appendnum = i -> "Number is: " + i;
        System.out.println(appendnum.function(25));

        System.out.println("Add number 25");
        Function<Integer, String> adanum = i -> "Number is: " + i;
        System.out.println(adanum.apply(25));

        System.out.println("List of people");
        List<Person> listPeople = getPeople();
        listPeople.forEach(System.out::println);
        System.out.println("Sort by age");
        sortByAge(listPeople);

        System.out.println("Sort by Name");
        sortByName(listPeople);

        System.out.println("Sort by height");
        sortByHeight(listPeople);
    }


    private static void sortByName(List<Person> people){
        people.sort(Comparator.comparing(Person::getName));
        people.forEach(System.out::println);
    }

    private static void sortByAge(List<Person> people){
        people.sort(Comparator.comparing(p -> p.getAge()));
        people.forEach(p -> System.out.println(p));
    }

    private static void sortByHeight(List<Person> people){
        people.sort(Comparator.comparing(Person::getHeight));
        people.forEach(System.out::println);
    }

    private static List<Person> getPeople(){
        return new ArrayList<>(List.of(
            new Person("Jay", 47, 170),
            new Person("Anya", 7, 171),
            new Person("Damion", 8, 172),
            new Person("Becky", 8, 173),
            new Person("Mike", 33, 174),
            new Person("Mary", 38, 175),
            new Person("Alan", 39, 176),
            new Person("Zoe", 40, 177)
        ));
    }

    interface Functionable<T, R>{
        R function(T t);
    }

    public static <T> boolean check(T t, Predicate<T> p){
        return p.test(t);
    }

    interface Checker<T>{
        boolean check(T t, Predicate<T> p);
    }
    interface Printable<String>{
        void consumer(String str);
    }

    interface Retrievable<Integer>{
        Integer supplier();
    }

    interface Evaluate<Integer>{
        boolean predicate(Integer i);
    }
}
