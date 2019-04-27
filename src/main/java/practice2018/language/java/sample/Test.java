package practice2018.language.java.sample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> itr = entrySet.iterator();
        while (itr.hasNext()) {
            System.out.println("THE NEXT VALUE IS " + itr.next());
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> itr_1 = integers.iterator();
        while (itr_1.hasNext()) {
            System.out.println("THE NEXT KEY IS " + itr_1.next());
        }
    }

}