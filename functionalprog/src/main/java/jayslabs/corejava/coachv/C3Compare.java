package jayslabs.corejava.coachv;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import jayslabs.corejava.entity.Person;

record Employee(String name, int age, double height) {
    // Constructor
    public Employee {
        // Validation logic can be added here if needed
    }
} 

public class C3Compare {

    final static List<Person> people = Arrays.asList(
    new Person("John", 20, 6.5),
    new Person("Sara", 21, 5.7),
    new Person("Jane", 21,4.11),
    new Person("Anya", 21, 5.7),
    new Person("Greg", 35, 5.11));

    final static List<Employee> employees = Arrays.asList(
        new Employee("John", 20, 6.5),
        new Employee("Sara", 21, 5.7),
        new Employee("Jade", 21, 5.7),
        new Employee("Jane", 21,4.11),
        new Employee("Greg", 35, 5.11));

    final static Comparator<Employee> byAge = Comparator.comparing(Employee::age);
    final static Comparator<Employee> descendingAge = Comparator.comparing(Employee::age).reversed(); 
    final static Comparator<Employee> height = Comparator.comparing(Employee::height);
    final static Comparator<Employee> byName = Comparator.comparing(Employee::name);

    public static void main(String[] args) {
        sortingTest();

        //System.out.println("youngest employee: ");
        minTest();

        //System.out.println("oldest employee: ");
        maxTest();
    }

    public static void minTest(){
        employees.stream().min(byAge)
        .ifPresent(emp -> System.out.println(emp.name() + " is the youngest employee"));
    }

    public static void maxTest(){
        employees.stream().max(byAge)  
        .ifPresent(emp -> System.out.println(emp.name() + " is the oldest employee"));
    }

    // .sorted()
    public static void sortingTest(){
        // List<Person> ascendingAge = people.stream()

        // .sorted(
        //     Comparator.comparing(Person::getAge)
        //     //Person::ageDifference
        //     //Person::nameComparator
        //     //Person::heightComparator
        // ).toList();
        
        // ascendingAge.forEach(System.out::println);

        
        //Sorts Employee by age
        List<Employee> sortedEmps = employees.stream()
        .sorted(byAge.thenComparing(byName))
        .toList();

        sortedEmps.forEach(System.out::println);

    }
}
