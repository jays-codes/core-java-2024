package jayslabs.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasAssignment2 {

    public static void main(String[] args) {
        // staticMR();
        // boundMR();
        // unboundMR();
        constructorMR();
    }

    public static void constructorMR(){
        System.out.println("\nconstructorMR()");

        Supplier<List<String>> listsup = () -> new ArrayList<>();
        List<String> list = listsup.get();
        list.add("lambda");
        System.out.println(list);

        //constructor method reference
        Supplier<List<String>> lsupplier = ArrayList::new;
        List<String> list2 = lsupplier.get();
        list2.add("method reference");
        System.out.println(list2);

        Function<Integer, List<String>> listfunc = (capacity) -> new ArrayList<>(capacity);
        List<String> list3 = listfunc.apply(10);
        list3.add("lambda");
        System.out.println(list3);

        //constructor method reference
        Function<Integer, List<String>> lfunc = ArrayList::new;
        List<String> list4 = lfunc.apply(10);
        list4.add("using constructor method reference");
        System.out.println(list4);
    }

    public static void staticMR() {
        System.out.println("static MR");
    
        List<Integer> intlist = Arrays.asList(1,2,7,4,5);
        intlist.forEach(System.out::println);

        System.out.println("\nafter sorting");
        Consumer<List<Integer>> sorter = list -> Collections.sort(list);
        sorter.accept(intlist);
        intlist.forEach(System.out::println);

        System.out.println("\ninitialize");
        intlist = Arrays.asList(1,2,7,4,5);
        intlist.forEach(System.out::println);

        //overload sort() and use method reference to sort intList
        System.out.println("\nafter sorting with method reference");
        Collections.sort(intlist, Integer::compare);
        intlist.forEach(System.out::println);
    }

    public static void boundMR(){
        System.out.println("\nboundMR()");
        
        String name = "Mr.Joe Bloggs";
        Predicate<String> isPrefixed = (prefix) -> name.startsWith(prefix);
        System.out.println(isPrefixed.test("Mr."));
        System.out.println(isPrefixed.test("Mrs."));

        //bound method reference
        System.out.println("\nbound method reference");
        Predicate<String> isPrefixedMR = name::startsWith;
        System.out.println(isPrefixedMR.test("Mr."));
        System.out.println(isPrefixedMR.test("Mrs."));
    }

    public static void unboundMR(){
        System.out.println("\nunboundMR()");

        Predicate<String> isEmpty = (str) -> str.isEmpty();
        System.out.println(isEmpty.test(""));
        System.out.println(isEmpty.test("xyz"));

        //unbound method reference
        System.out.println("\nunbound method reference");
        Predicate<String> isemptymr = String::isEmpty;
        System.out.println(isemptymr.test(""));
        System.out.println(isemptymr.test("xyz"));

        System.out.println("\nBiPredicate");
        BiPredicate<String, String> isprefixof = (str, prefix) -> str.startsWith(prefix);
        System.out.println(isprefixof.test("Mr.Joe Bloggs", "Mr."));
        System.out.println(isprefixof.test("Mr.Joe Bloggs", "Ms."));

        System.out.println("\nBiPredicate method reference");
        BiPredicate<String, String> isprefixofmr = String::startsWith;
        System.out.println(isprefixofmr.test("Mr.Joe Bloggs", "Mr."));
        System.out.println(isprefixofmr.test("Mr.Joe Bloggs", "Ms."));
    }
}
