package jayslabs.corejava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CollectionsNotes {

    public static void main(String[] args) {
        System.out.println("Collections Notes");
    
        //listDemo();
        //stackDemo();
        //linkedListDemo();
        setDemo();
        
    }

    public static void listDemo() {
        List<String> strlist = new ArrayList<>();
        strlist.add("anna");
        strlist.add("bob");
        strlist.add("charlie");
        strlist.add("david");
        strlist.add(0, "edward");
        System.out.println(strlist);

        System.out.println("\nRemoving names with length less than 5 chars");
        strlist.removeIf(s -> s.length() < 5);
        System.out.println(strlist);

        System.out.println("\nPrinting names in uppercase and length");
        strlist.forEach(s -> {
            System.out.println(s.toUpperCase() + " " + s.length());
        });

        System.out.println("\nList replaceAll() demo");
        List<String> strlist2 = Arrays.asList("anna", "bob", "charlie", "david", "edward");
        // strlist2.forEach(s -> {
        //     System.out.println(s.toUpperCase() + " " + s.length());
        // });
        //strlist2.add("frank");

        System.out.println("\nreplaceAll() call");
        strlist2.replaceAll(s -> s.toUpperCase() + " " + s.length());
        strlist2.forEach(System.out::println);

        System.out.println("\nList set() demo");
        strlist2.set(0, "ANNA 5000");
        strlist2.forEach(System.out::println);
        
    }

    public static void stackDemo() {
        System.out.println("\nStack demo");
        Stack<String> strstack = new Stack<>();
        strstack.push("anna");
        strstack.push("bob");
        strstack.push("charlie");
        strstack.push("david");
        strstack.push("edward");
        System.out.println(strstack);

        System.out.println("\nStack pop() demo");
        System.out.println("popped: " + strstack.pop());
        System.out.println(strstack);
    }

    public static void linkedListDemo() {
        System.out.println("\nLinkedList demo");
        LinkedList<String> strlist = new LinkedList<>();
        strlist.add("anna");
        strlist.add("bob");
        strlist.add("charlie");
        strlist.add("david");
        System.out.println(strlist);

        System.out.println("\nLinkedList addFirst() demo");
        strlist.addFirst("edward");
        System.out.println(strlist);

        System.out.println("\nLinkedList addLast() demo");
        strlist.addLast("apple");
        System.out.println(strlist);

        System.out.println("\nLinkedList removeFirst() demo");
        strlist.removeFirst();
        System.out.println(strlist);

        System.out.println("\nLinkedList removeLast() demo");
        strlist.removeLast();
        System.out.println(strlist);
    }

    public static void setDemo() {
        System.out.println("\nSet demo");

        Set<String> strset = new HashSet<>();
        strset.add("anna");
        strset.add("bob");
        strset.add("charlie");
        strset.add("david");
        System.out.println(strset);

        
    }   
}
