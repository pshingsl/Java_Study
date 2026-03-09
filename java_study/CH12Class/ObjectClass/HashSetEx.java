package Class.ObjectClass;

import java.util.HashSet;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        Student s1 = new Student(1, "학생1");
        hashSet.add(s1);
        System.out.println("저장된 객체 수:" + hashSet.size());

        Student s2 = new Student(1, "학생1");
        hashSet.add(s2);
        // Student에서 재정의한 hashCode() 메소드에 의해서 중복 저장 안됨
        System.out.println("저장된 객체 수:" + hashSet.size());

        Student s3 = new Student(1, "학생2");
        hashSet.add(s3);
        System.out.println("저장된 객체 수:" + hashSet.size());
    }
}
