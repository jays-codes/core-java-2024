package codi;

import java.util.Map;
import java.util.Optional;

public class CodingTest {
    public static void main(String[] args) {

        // Create the map using streams
        Map<Integer, Boolean> map = java.util.stream.IntStream.rangeClosed(1, 1600)
                .boxed()
                .collect(java.util.stream.Collectors.toMap(i -> i, i -> false));

        // Example usage: Print the size of the map
        System.out.println("Map size: " + map.size());
        
        // Test the methods
        int allocatedId = allocateIp(map, 400);
        System.out.println("Allocated IP: " + allocatedId);
        System.out.println("Deallocating IP: " + allocatedId);
        deallocateIp(map, allocatedId);
        System.out.println("IP status after deallocation: " + map.get(allocatedId));
    }

    public static int allocateIp(Map<Integer, Boolean> map, int ipCount) {
        // Define range based on ipCount using switch expression
        record Range(int start, int end) {}
        
        Range range;
        if (ipCount <= (1 << 4)) { // ipCount <= 2^4
            range = new Range(1, 1000);
        } else if (ipCount <= (1 << 8)) { // ipCount <= 2^8
            range = new Range(1001, 1500);
        } else if (ipCount <= (1 << 12)) { // ipCount <= 2^12
            range = new Range(1501, 1600);
        } else {
            range = null;
        }
        
        if (range == null) return -1;
        
        // Find first available key in the determined range, mark it allocated, and return it
        return java.util.stream.IntStream.rangeClosed(range.start(), range.end())
                .filter(key -> !map.get(key))
                .findFirst()
                .stream()
                .peek(key -> map.put(key, true))
                .findFirst()
                .orElse(-1);
    }
    
    public static boolean deallocateIp(Map<Integer, Boolean> map, int id) {
        return Optional.ofNullable(map.get(id))
                .filter(allocated -> allocated)
                .map(allocated -> {
                    map.put(id, false);
                    return true;
                })
                .orElse(false);
    }
}
