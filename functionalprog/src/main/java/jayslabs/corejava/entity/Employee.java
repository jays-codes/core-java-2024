package jayslabs.corejava.entity;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private String department;
    private LocalDate hireDate;

    // Update constructor to include department
    public Employee(String name, double salary, String department, LocalDate hireDate) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.hireDate = hireDate;
    }

    // Add getter for department
    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }   

    public LocalDate getHireDate() {
        return hireDate;
    }

    // Update equals method to include department
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(hireDate, employee.hireDate);
    }

    // Update hashCode to include department
    @Override
    public int hashCode() {
        return Objects.hash(name, salary, department, hireDate);
    }

    // Update toString to include department
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }

    // Replace static comparison methods with Comparator fields
    public static final Comparator<Employee> COMPARE_BY_SALARY = 
        Comparator.comparingDouble(Employee::getSalary);

    public static final Comparator<Employee> COMPARE_BY_HIRE_DATE = 
        Comparator.comparing(Employee::getHireDate);

    public static final Comparator<Employee> COMPARE_BY_NAME = 
        Comparator.comparing(Employee::getName);

    // Add a new comparator for department
    public static final Comparator<Employee> COMPARE_BY_DEPARTMENT = 
        Comparator.comparing(Employee::getDepartment);
}
