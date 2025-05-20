package jayslabs.corejava.coachv;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors; 

import jayslabs.corejava.entity.Person;

public class C3Collectors {

    final static List<Person> people = Arrays.asList(
        new Person("John", 20, 6.5),
        new Person("Sara", 21, 5.7),
        new Person("Jane", 24,4.11),
        new Person("Anya", 21, 5.7),
        new Person("Greg", 35, 5.11));

    final static List<Employee> employees = Arrays.asList(
        new Employee("John", 20, 6.5, "HR"),
        new Employee("Sara", 21, 5.7, "IT"),
        new Employee("Jade", 21, 5.7, "IT"),
        new Employee("Jane", 21,4.11, "HR"),
        new Employee("Greg", 35, 5.11, "IT"));

    public static void main(String[] args) {
        // Collectors

        testGroupingBy();
        //testCollect();
        //testCollectToMap();
    }

    public static void testCollect(){

        List<String> over58 = people.stream()
            .filter(p -> p.getAge() > 21)
            .map(Person::getName)
            .collect(Collectors.toList());
            //.collect(toList());

        System.out.println("Persons over 24: " + over58);
    }

    public static void testCollectToMap(){

        Map<String, Person> over58 = people.stream()
            .collect(Collectors.toMap(
                Person::getName,
                person -> person));
            //.collect(toList());

        System.out.println("Persons Map: " + over58);
    }

    //given list of Employees, create a map where their dept is the key 
    //and value is all people in that dept
    public static void testGroupingBy(){
        System.out.println("Employees by dept: " + 
            employees.stream()
            .collect(Collectors.groupingBy(
                Employee::dept
                , Collectors.mapping(
                    Employee::name, Collectors.toList())
            ))
        );
        //System.out.println("Employees by dept: " + employeesByDept);

    }
}
