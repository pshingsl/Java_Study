package Collections.TreeSet;

import java.util.*;

public class TreeMapEx {
    public static void main(String[] args) {
        // TreeMap 컬렉션  새 ㅇ성
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        //엔트리 저장
        treeMap.put("apple", 10);
        treeMap.put("app", 80);
        treeMap.put("ever", 20);
        treeMap.put("zoo", 30);
        treeMap.put("hi", 40);
        treeMap.put("ho", 50);
        treeMap.put("base", 60);
        treeMap.put("gues", 70);

        // 정렬된 엔트리 하나씩 가져오기 -> TreeMap은 키 위주로 정렬이 된다,
        Set<Map.Entry<String, Integer>> entries = treeMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        System.out.println();

        // 특징 키에 대합 값 가져오기
        Map.Entry<String, Integer> entry = null;
        entry = treeMap.firstEntry();
        System.out.println("제일 앞 단어: " + entry.getKey() + " - " + entry.getValue());
        entry = treeMap.lastEntry();
        System.out.println("제일 뒤 단어: " + entry.getKey() + " - " + entry.getValue());
        entry = treeMap.lowerEntry("base");
        System.out.println("base 앞 단어: " + entry.getKey() + " - " + entry.getValue());
        System.out.println();

        // 내림차순으로 정렬
        NavigableMap<String, Integer> decendingMap = treeMap.descendingMap();
        Set<Map.Entry<String, Integer>> decendingEntrySet = decendingMap.entrySet();
        for(Map.Entry<String, Integer> e: decendingEntrySet){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        System.out.println();

        // 범위 검색
        System.out.println("c~h 사이의 단어 검색");
        NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "h", false);
        for(Map.Entry<String, Integer> e : rangeMap.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }
}
