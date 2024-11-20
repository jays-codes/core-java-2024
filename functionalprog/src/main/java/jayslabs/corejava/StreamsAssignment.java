package jayslabs.corejava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import jayslabs.corejava.entity.AnotherBook;

public class StreamsAssignment {
    public static void main(String[] args) {
        System.out.println("Streams Assignment");
        //question1();
        //question2();
        //question3();
        //question4();
        //question5();
        //question5ans();
        //question6();
        //question7();
        //question8();
        //question9();
        //question10();
        //question11();
        //question12();
        //question13();
        question14();
    }

    public static void question1(){
        System.out.println("\n\nQuestion 1 - Stream a list of int primitives between the " +
        "range of 0 (inclusive) and 5 (exclusive). Calculate and output the average");
        Double average = IntStream.range(0,5).average().getAsDouble();
        System.out.println("Average: " + average);
    }

    public static void question2(){
        System.out.println("\n\nQuestion 2");
        List<Item> items = Arrays.asList(
            new Item(1, "Screw"), 
            new Item(2, "Nail"), 
            new Item(3, "Bolt"));
        items.stream().sorted(Comparator.comparing(Item::getName)).forEach(System.out::print);
    }

    public static void question3(){
        System.out.println("\n\nQuestion 3");
        /*
         * Generate a Stream<List<String>> using the Stream.of(Arrays.asList(“a”, “b”), 
         * Arrays.asList(“a”, “c”)) method call. Filter the stream so that only list’s 
         * that contain “c” make it through the filter. 
         * Flatten the Stream<List<String>> to a Stream<String> using the flatMap() operation.  
         * Use forEach() to output the new stream.
        */

        Stream<List<String>> strStream = Stream.of(
            Arrays.asList("a", "b"),
            Arrays.asList("d", "c"),
            Arrays.asList("a", "c"));
        
        //filter for List with "c"
        //strStream.filter(list -> list.contains("c")).forEach(System.out::println);
        strStream.filter(list -> list.contains("c"))
            //.peek(list -> System.out.println("\n"+list)) // 1. [d,c]    2. [a,c]
            .flatMap(list -> list.stream())
            .forEach(str -> System.out.print(str+ " "));
        //.forEach(System.out::print);
    }

    public static void question4(){
        System.out.println("\n\nQuestion 4.a");

        //Using 1, 2 and 3 create a List of Integers
        List<Integer> intList = Arrays.asList(1,3,2);

        //Stream the list and calculate the sum, using the sum() method from IntStream.
        int sum = intList.stream().mapToInt(n->n).sum();
        System.out.println("Sum: " + sum);

        //int max = intList.stream().max(Integer::compare).get();
        int max = intList.stream().mapToInt(n->n).max().getAsInt();
        System.out.println("Max: " + max);

        System.out.println("\n\nQuestion 4.b");
        //Given the Person class (in the zip file), 
        //declare a List typed for Person with the following Person’s:

        List<Person> pList = Arrays.asList(
            new Person("Allan", "Burke", 22),
            new Person("Zoe", "Peters", 20),
            new Person("Peter", "Castle", 29)
        );

        //Stream the list and find the oldest person.
        Person oldest = pList.stream().max(Comparator.comparing(Person::getAge)).orElse(null);
        System.out.println("Oldest is: " + oldest.getFirstName() +", at age: " + oldest.getAge());

        System.out.println("\n\nQuestion 4.c");
        List<Integer> intList2 = Arrays.asList(10, 47, 33, 23);
        int max2 = intList2.stream().reduce(0, (a,b) -> a>b?a:b);
        System.out.println("Max2: " + max2);

        int max3 = intList2.stream().reduce((a,b) ->a>b?a:b).get();
        System.out.println("Max3: " + max3);
       
    }

    public static void question5(){
        System.out.println("\n\nQuestion 5");
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);

        System.out.println("Grade1: " + grade1.orElse("UNKNOWN"));
        if (grade2.isPresent()){
            grade2.ifPresent(str -> System.out.println("Grade2: " + str));
        } else {
            System.out.println("Grade2: " + grade2.orElse("Empty"));
        }

    }


    public static void question6(){
        System.out.println("\n\nQuestion 6");

        List<Book> books = Arrays.asList(
            new Book("Thinking in Java", 30.0),
            new Book("Java in 24 hrs", 20.0),
            new Book("Java Recipes", 10.0)
        );

        var avgPrice = books.stream().filter(book -> book.getPrice() > 90)
                        .flatMapToDouble(book -> DoubleStream.of(book.getPrice()))
                        .average();
        
        if (avgPrice.isPresent())
            System.out.print("avg: " + avgPrice.getAsDouble());
        else
            System.out.print("No books found");
    }

    public static void question7(){
        System.out.println("\n\nQuestion 7");

        List<Book> books = Arrays.asList(
            new Book("Atlas Shrugged", 10.0),
            new Book("Freedom at Midnight", 5.0),
            new Book("Gone with the wind", 5.0)
        );

        Map<String, Double> bookmap = books.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice));
        
        //print values of books starting with "A"
        bookmap.forEach((k,v) -> {
            if (k.startsWith("A")) System.out.println(k + ": " + v);
        });
    }

    public static void question8(){
        System.out.println("\n\nQuestion 8");

        List<Book> books = Arrays.asList(
            new Book("Gone with the wind", 5.0),
            new Book("Gone with the wind", 10.0),
            new Book("Atlas Shrugged", 15.0)
        );

        books.stream()
        //.collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice(), (v1,v2) -> v1*v2)) 
        .collect(Collectors.toMap(Book::getTitle, Book::getPrice,(v1,v2) -> v1*v2))
        .forEach((k,v) -> System.out.println(k + ": " + v));
    }

    public static void question9(){
        System.out.println("\n\nQuestion 9");

        List<Person> pList = Arrays.asList(
            new Person("Bob", "Burke", 31),
            new Person("Paul", "Peters", 32),
            new Person("John", "Castle", 33)
        );

        double avg = pList.stream().filter(p -> p.getAge() < 43).mapToInt(Person::getAge).average().orElse(0.0);
        System.out.println("Average age: " + avg);
    }

    public static void question10(){
        System.out.println("\n\nQuestion 10");
        
        Optional<Double> price = Optional.ofNullable(34.6);
        System.out.println(price);
        
        price.ifPresent(p -> System.out.println("Price: " + p));
        System.out.println("Price orelse: " + price.orElse(0.0));
        System.out.println("Price orelseget: " + price.orElseGet(()->100.0));

        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println("Price2: " + price2);
        if (price2.isEmpty())
            System.out.println("Price2 is empty");
        price2.ifPresent(p -> System.out.println("Price2 ifpresent: " + p));

        Optional<Double> price3 = Optional.ofNullable(null);
        Double z = price3.orElseThrow(()->new RuntimeException("Bad code"));
        System.out.println("Z: " + z);
    }

    public static void question11(){
        System.out.println("\n\nQuestion 11");
        
        List<AnotherBook> books = Arrays.asList(
            new AnotherBook("Gone with the wind", "Fiction"),
            new AnotherBook("Bourne Ultimatum", "Thriller"),
            new AnotherBook("The Client", "Thriller")
        );

        List<String> genres = books.stream().map(AnotherBook::getGenre).distinct().collect(Collectors.toList());
        System.out.println("Genres: " + genres);
    }

    public static void question12(){
        System.out.println("\n\nQuestion 12");

        double sum = DoubleStream.of(0,2,4).filter(n -> n%2!=0).sum();
        System.out.println("Sum: " + sum);
    
        Stream.of(1.0, 3.0, 0,2,4).mapToDouble(n -> n.doubleValue())
        .filter(n -> n%2==0).average().ifPresent(System.out::println);
    }

    public static void question13(){
        System.out.println("\n\nQuestion 13");

        List<Integer> ls = Arrays.asList(11,11,22,33,33,55,66,77);
        boolean result = ls.stream().distinct().anyMatch(n -> n==11);
        System.out.println("Result: " + result);

        boolean nonematch = ls.stream().distinct().noneMatch(x -> x%11>0);
        System.out.println("Nonematch: " + nonematch);
    }

    public static void question14(){
        System.out.println("\n\nQuestion 14");
        //a.) because ai.incrementAndGet() never fires because the predicate always returns false
        
        AtomicInteger ai = new AtomicInteger();
        Stream.of(11,11,22,33).parallel()
        .filter(n->{
            ai.incrementAndGet();
            return n%2==0;
        })
        .forEach(System.out::println);
        
        System.out.println("ai: " + ai);

    }

    public static void question5ans(){
        System.out.println("\n\nQuestion 5 answer");

        Optional<String> grade1 = getGrade2(50);// returns an empty Optional
        Optional<String> grade2 = getGrade2(55);// returns "PASS" Optional
        System.out.println(grade1.orElse("UNKNOWN"));// UNKNOWN
        if(grade2.isPresent()){
            grade2.ifPresent(x->System.out.println(x));// PASS
        }else{
            System.out.println(grade2.orElse("Empty"));
        }
    }



    public static Optional<String> getGrade2(int marks){
        Optional<String> grade = Optional.empty();
        if(marks>50){
            grade = Optional.of("PASS");
        }
        else {
            grade.of("FAIL");// Optionals are immutable!
        }
        return grade;
    }

    public static Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();
        if(marks > 50){
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");
        }
        return grade;
    }


}

class Book{     
    private String title;     
    private double price;     
    Book(String title, double price){         
        this.title = title;         
        this.price = price;     
    }     
    public String getTitle() {   return title;}
    public double getPrice() {   return price;}
    public String toString() { return title+ " " + price;}
}

class Item{     
    private int id;     
    private String name;     
    public Item(int id, String name){         
        this.id = id;         
        this.name = name;     
    }     
    public Integer getId() {         
        return id;     
    }      
    public void setId(int id) {         
        this.id = id;     
    }      
    public String getName() {         
        return name;     
    }      
    public void setName(String name) {         
        this.name = name;     
    }     
    public String toString(){    // outputs the name   
        return name;     
    } 
}

class Person{
    private String firstName, lastName;
    private Integer age;

    Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
    }
    
}