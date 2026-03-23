package NestedClass.C3;

public class C {
    // 정적 멤버 클래스
    static class D {

        //  인스턴스 필드
        int field1 = 1;

        // 정적 필드(Java 17부터 허용)
        static int field2 = 2;

        // 생성자
        D() {
            System.out.println("D-생성자 실행");
        }

        // 인스턴스 메서드
        void method1() {
            System.out.println("D-메소드1 실행");
        }

        // 정적 메소드(Java 17부터 허용)
        static void method2() {
            System.out.println("D-메소드2 실행");
        }
    }
}
