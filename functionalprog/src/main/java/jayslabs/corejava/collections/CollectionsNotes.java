package jayslabs.corejava.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionsNotes {

    public static void main(String[] args) {
        System.out.println("Collections Notes");
    
        List<String> strlist = new ArrayList<>();
        strlist.add("anna");
        strlist.add("bob");
        strlist.add("charlie");
        strlist.add("david");
        strlist.add("edward");
        System.out.println(strlist);

        System.out.println("\nRemoving names with length less than 5 chars");
        strlist.removeIf(s -> s.length() < 5);
        System.out.println(strlist);

        System.out.println("\nPrinting names in uppercase and length");
        strlist.forEach(s -> {
            System.out.println(s.toUpperCase() + " " + s.length());
        });
    }
}
