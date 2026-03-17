package Collections.TreeSet;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        // TreeSet 컬렉션 생성
        TreeSet<Integer> scores = new TreeSet<>();

        // Integer 객체 저장
        scores.add(98);
        scores.add(78);
        scores.add(98); // Set의 특징으로 중복을 할 수 없다.
        scores.add(88);
        scores.add(76);
        scores.add(100);

        // 정렬된 Integer 객체를 하나씩 가져오기
        for(Integer s : scores){
            System.out.print(s + " "); // 자동 정렬되서 출력
        }
        System.out.println("\n");

        // 특정 Integer객체 가져오기
        System.out.println("가장 낮은 점수: " + scores.first());
        System.out.println("가장 높은 점수: " + scores.last());
        System.out.println("95점 아래 점수: " + scores.lower(95));
        System.out.println("95점 위의 점수: " + scores.higher(95));
        System.out.println("95점이거나 바로 아래 점수" + scores.floor(95));
        System.out.println("85점이거나 바로 위의 점수" +  scores.ceiling(85) + "\n");

        // 내림차순으로 정렬하기
        NavigableSet<Integer> descendingSccores = scores.descendingSet();
        for(Integer s : descendingSccores){
            System.out.print(s + " ");
        }
        System.out.println();

        // 범위 검색(80<=)
        NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
        for(Integer s : rangeSet){
            System.out.print(s + " ");
        }
        System.out.println();

        // 범위 검색(80<= score < 90)
        rangeSet = scores.subSet(80, true, 90, false);
        for(Integer s : rangeSet){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
