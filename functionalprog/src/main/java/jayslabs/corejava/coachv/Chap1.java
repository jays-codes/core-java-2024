package jayslabs.corejava.coachv;

import java.util.List;

public class Chap1 {
    public static void main(String[] args) {
    
        //List of random integers
        final var prices = List.of(10, 30, 17, 20, 18, 45, 12);
    
        //System.out.println("(imperative) total: " + discountedPriceImperative(prices));
        System.out.println("(functional) total: " + discountedPricesFunctional(prices));
    }

    public static Double discountedPriceImperative(List<Integer> prices) {
        double total = 0.0;
        for (int price : prices) {
            if (price > 20) 
                total += price * 0.9; // 10% discount             
        }
        return total;
    }

    public static Double discountedPricesFunctional(List<Integer> prices) {
        return prices.stream()
                .filter(price -> price > 20)
                .mapToDouble(price -> price * 0.9)
                .sum();
    }
}
