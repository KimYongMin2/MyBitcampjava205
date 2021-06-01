package myproject.ListSet;

import java.util.HashMap;

public class FPlayerMap {
    public static void main(String[] args) {
        HashMap<Integer, FootballPlayer> hashMap = new HashMap<>();

        hashMap.put(1, new FootballPlayer("홍길동", 1, "asd", 17));
        hashMap.put(3, new FootballPlayer("홍길동", 3, "asd", 17));
        hashMap.put(4, new FootballPlayer("홍길순", 4, "asd", 15));
        hashMap.put(2, new FootballPlayer("홍길동", 2, "asd", 17));
        hashMap.put(6, new FootballPlayer("홍길동", 6, "asd", 17));

        for (Integer integer : hashMap.keySet()) {
            System.out.println(hashMap.get(integer));
        }
    }
}
