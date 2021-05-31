package collector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectorEx {
    public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("First");
    list.add("Second");
    list.add("Third");
    list.add("Forth");
    list.add("Final");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("------------------------------------------");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("--------------------------------------------");
        Iterator<String> iterator = list.listIterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
    }

}
