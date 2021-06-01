package myproject.ListSet;

import java.util.Iterator;
import java.util.TreeSet;

public class FPlayerTreeSet {
    public static void main(String[] args) {
        TreeSet<FootballPlayer> treeSet = new TreeSet<>();

        treeSet.add(new FootballPlayer("홍길동", 7, "asd", 17));
        treeSet.add(new FootballPlayer("홍길동", 1, "asd", 17));
        treeSet.add(new FootballPlayer("홍길동", 3, "asd", 17));
        treeSet.add(new FootballPlayer("홍길순", 4, "asd", 15));
        treeSet.add(new FootballPlayer("홍길동", 1, "asd", 17));
        treeSet.add(new FootballPlayer("홍길동", 1, "bas", 17));
        treeSet.add(new FootballPlayer("김이박", 2, "bas", 17));
        treeSet.add(new FootballPlayer("김이박", 2, "asd", 17));
        treeSet.add(new FootballPlayer("박이김", 5, "asd", 17));
        treeSet.add(new FootballPlayer("이박김", 2, "asd", 17));
        treeSet.add(new FootballPlayer("홍길순", 4, "bas", 15));
        treeSet.add(new FootballPlayer("박이김", 5, "bas", 17));

        Iterator<FootballPlayer> iterator = treeSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
