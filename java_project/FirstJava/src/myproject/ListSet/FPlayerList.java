package myproject.ListSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FPlayerList {
    public static void main(String[] args) {
        List<FootballPlayer> list = new ArrayList<FootballPlayer>();

        list.add(new FootballPlayer("홍길동", 1, "asd", 17));
        list.add(new FootballPlayer("홍길동", 3, "asd", 17));
        list.add(new FootballPlayer("홍길순", 4, "asd", 15));
        list.add(new FootballPlayer("홍길동", 1, "asd", 17));

        Iterator<FootballPlayer> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
