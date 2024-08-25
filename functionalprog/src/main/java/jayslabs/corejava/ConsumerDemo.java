package jayslabs.corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {
    //main method
    public static void main(String[] args) {
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("Consumer Demo: Hello, World!");

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        BiConsumer<String,String> mapPrint = (k,v) -> System.out.println(k + ":" + v);

        map.forEach(mapPrint);
    }
}
