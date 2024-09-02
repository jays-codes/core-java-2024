package jayslabs.corejava;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import jayslabs.corejava.entity.Employee;

public class CustomEntitySort {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("alpha", 50000.0, "ABC Department", LocalDate.of(2020, 2, 1)),
            new Employee("romeo", 60000.0, "XYZ Department", LocalDate.of(2021, 2, 1)),
            new Employee("charlie", 550000.0, "Finance Department", LocalDate.of(2022, 3, 1)),
            new Employee("victor", 5000.0, "Audit Department", LocalDate.of(2020, 1, 1))
        );

        //sort by date hired
        System.out.println("Sort by date hired");
        employees.sort(Employee.COMPARE_BY_HIRE_DATE);
        employees.forEach(System.out::println);

        //sort by salary
        System.out.println("Sort by salary");
        employees.sort(Employee.COMPARE_BY_SALARY);
        employees.forEach(System.out::println);

        //sort by name
        System.out.println("Sort by name");
        employees.sort(Employee.COMPARE_BY_NAME);
        employees.forEach(System.out::println);
    }

}
