package Collections.Set;

import java.util.HashSet;
import java.util.Set;

public class SetEx {
    public static void main(String[] args) {
        // HashSet 컬렉션 생성
        Set<String> set = new HashSet<String>();

        // 객체 저장
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Sprin");
        set.add("MySQL");

        // 저장된 객체 수 출력
        int size = set.size();
        System.out.printf("총 객체 수: " + size);
        System.out.println();

        // HashSet 컬렉션 생성
        Set<Member> set1 = new HashSet<Member>();

        // Member 객체 저장
        set1.add(new Member("박상혁", 26));
        set1.add(new Member("박상혁", 26));
        set1.add(new Member("박상혁", 23));

        // 저장된 객체 수 출력
        int size2 = set1.size();
        System.out.printf("총 객체 수: " + size2);
    }
}
