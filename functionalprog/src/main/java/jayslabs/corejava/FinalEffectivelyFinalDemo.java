package jayslabs.corejava;

import java.util.function.IntSupplier;

public class FinalEffectivelyFinalDemo {
    public static void main(String[] args) {
        // Final variable
        final int finalVar = 10;
        IntSupplier supplier1 = () -> finalVar * 2;
        System.out.println(supplier1.getAsInt()); // Output: 20

        // Effectively final variable
        int effectivelyFinalVar = 20;
        IntSupplier supplier2 = () -> effectivelyFinalVar * 2;
        System.out.println(supplier2.getAsInt()); // Output: 40
        
        // Not effectively final (will cause compilation error if used in lambda)
        int mutableVar = 30;
        mutableVar = 40; // This assignment makes mutableVar not effectively final
        // IntSupplier supplier3 = () -> mutableVar * 2; // Compilation error

        // Using instance variables (which can be modified)
        FinalEffectivelyFinalDemo demo = new FinalEffectivelyFinalDemo();
        IntSupplier supplier4 = () -> demo.instanceVar * 2;
        System.out.println(supplier4.getAsInt()); // Output: 60
        demo.instanceVar = 40;
        System.out.println(supplier4.getAsInt()); // Output: 80
    }

    private int instanceVar = 30;
}
