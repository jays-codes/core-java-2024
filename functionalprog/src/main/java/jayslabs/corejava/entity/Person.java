package jayslabs.corejava.entity;

public class Person {
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    //toString
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", height=" + height + "]";
    }

    public int ageDifference(Person other) {
        return this.age - other.age;
    }

    public int heightComparator(Person other) {
        return Double.compare(this.height, other.height);
    }

    public int nameComparator(Person other) {
        return this.name.compareTo(other.name);
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() { 
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
