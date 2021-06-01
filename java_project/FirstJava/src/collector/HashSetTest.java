package collector;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("First");
        hashSet.add("Second");
        hashSet.add("First");
        hashSet.add("Third");

        Iterator<String> iterator = hashSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
