package practice2018.language.java.collectionsframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// author -- hemantkumar
public class Sample {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(1, 7);
        a.add(12);
        a.add(11);
        a.sort(Comparator.naturalOrder());
        a.forEach(System.out::println);
        System.out.println(Collections.binarySearch(a, 10));
//        b.add(3);
//        b.add(1);
//
//
////        a.retainAll(b);
//
////        System.out.println(a.removeAll(b));
////        b.replaceAll(x -> x + 1);
//
//        a.removeIf(x -> x % 2 == 0);
//        a.forEach(System.out::println);
////        b.forEach(System.out::println);

    }
}
