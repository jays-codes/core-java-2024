package jayslabs.corejava;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class AppTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals(25, solution.solution(new int[]{180, -50, -25, -25}, new String[]{"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"}));
    }
}

class Solution {
    public int solution(int[] A, String[] D) {
        int balance = 0;
        Map<Month, Integer> cardPaymentsCount = new HashMap<>();
        Map<Month, Integer> cardPaymentsTotal = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int amount = A[i];
            LocalDate date = LocalDate.parse(D[i]);
            Month month = date.getMonth();

            balance += amount;

            if (amount < 0) { // Card payment
                cardPaymentsCount.put(month, cardPaymentsCount.getOrDefault(month, 0) + 1);
                cardPaymentsTotal.put(month, cardPaymentsTotal.getOrDefault(month, 0) + Math.abs(amount));
            }
        }

        for (Month month : Month.values()) {
            int count = cardPaymentsCount.getOrDefault(month, 0);
            int total = cardPaymentsTotal.getOrDefault(month, 0);

            if (count < 3 || total < 100) {
                balance -= 5; // Deduct monthly card fee
            }
        }

        return balance;
    }
}