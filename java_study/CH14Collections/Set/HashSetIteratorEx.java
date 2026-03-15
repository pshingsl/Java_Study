package Collections.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetIteratorEx {
    public static void main(String[] args) {
    // HashSet 컬렉션 생성
        Set<String> set = new HashSet<>();

        // 객체 저장
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");
        set.add("MySQL");

        // 객체를 하나씩 가져와서 처리
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();  // 객체를 하나 가져오기
           // System.out.println(element);       // 가져온 데이터를 '먼저 출력'함
            if(element.equals("Java")){        // 그 다음 "Java"인지 확인
                iterator.remove();             // 위 조건이 맞다면 객체를 컬렉션에서 제거

                // 실제 Set 바구니에서는 제거됨.
                // 하지만 아래에서 element를 출력하면, 이미 꺼내온 데이터라 화면에는 찍힘.
                // 즉, 제거가 안 된 게 아니라 '출력 순서' 때문에 제거 안 된 것처럼 보이는 것임!
                System.out.println("element 제거 성공: " +element);
            }
            System.out.println(element);
        }
        System.out.println();

        // 객체 제거
        set.remove("JDBC"); // "JDBC" 삭제

        // 객체를 하나씩 가져와서 처리
        for(String element: set){
            if(element.equals("Java")){
                // 위 조건이 맞다면 객체를 컬렉션에서 제거
                iterator.remove();
            }
            System.out.println(element);
        }
    }
}
