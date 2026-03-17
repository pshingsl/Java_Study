package Collections.TreeSet;

import java.util.TreeSet;

public class ComparableEx {
    public static void main(String[] args) {
         // TreeSet 컬렉션 생성
        TreeSet<Person> treeSet = new TreeSet<>();

        // 객체 저장
        treeSet.add(new Person("Hyuk", 26));
        treeSet.add(new Person("Ace", 21));
        treeSet.add(new Person("Boo", 22));

        // 객체를 하나씩 가져오기
        for(Person p : treeSet){
            System.out.println(p.name + ", " + p.age);
        }
    }
}
