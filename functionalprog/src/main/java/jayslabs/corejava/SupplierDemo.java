package jayslabs.corejava;

import java.util.function.Supplier;

public class SupplierDemo {
    //main method
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello, World!";
        System.out.println(supplier.get());
    
    }

    //generic method for Supplier
    public static <T> T get(Supplier<T> supplier){
        return supplier.get();
    }
}
