package Collections.Immutable_Collections;

import java.util.*;

public class ImmutableEx {
    public static void main(String[] args) {
        // List 불변 컬렉션 생성
        List<String> immutableList = List.of("A", "B", "c");
        //immutableList.add("E");
        System.out.println("immutableList: " + immutableList);

        // Set 불변 컬렉션 생성
        Set<String> immutableSet = Set.of("A", "B", "c");
        //immutableSet.add("E");
        System.out.println("immutableSet: " + immutableSet);

        // Map 불변 컬렉션 생성
        Map<String, Integer> immutableMap = Map.of("A", 1, "B", 2, "C", 3);
        //immutableMap.add("E",4);
        System.out.println("immutableMap: " + immutableMap);
        System.out.println();

        // List 불변 컬렉션 복사
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        List<String> immutableList2 = List.copyOf(list);
        System.out.println("immutableList2: " + immutableList2);

        // Set 불변 컬렉션 복사
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        Set<String> immutableSet2 = Set.copyOf(set);
        System.out.println("immutableSet2: " + immutableSet2);

        // Map 불변 컬렉션 복사
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        Map<String, Integer> immutableMap2 = Map.copyOf(map);
        System.out.println("immutableMap2: " + immutableMap2);
        //immutableMap.add("E",4);
    }
}
