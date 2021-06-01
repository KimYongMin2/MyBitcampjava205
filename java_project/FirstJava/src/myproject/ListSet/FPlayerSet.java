package myproject.ListSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FPlayerSet {
    public static void main(String[] args) {
        Set<FootballPlayer> set = new HashSet<>();

        set.add(new FootballPlayer("홍길동", 1, "asd", 17));
        set.add(new FootballPlayer("홍길동", 3, "asd", 17));
        set.add(new FootballPlayer("홍길순", 4, "asd", 15));
        set.add(new FootballPlayer("홍길동", 1, "asd", 17));

        Iterator<FootballPlayer> iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
