package NestedClass.C2;

/*
 * 클래스에는 필드, 생성자, 메소드, 중첩 클래스를 만들 수 있다.
 * 중첩 클래스는 필드, 생성자, 메소드을 만들 수 있다.
 * */

public class C {
    // 인스턴스 멤버 클래스 생성
    class D {
        // 인스턴스 필드
        int field1 = 1;

        // 정적 필드(Java 17부터 허용)
        static int field2 = 2;

        // 생성자
        D() {
            System.out.println("D-생성자 실행");
        }

        // 인스턴스 메소드
        void method1() {
            System.out.println("D-method1 실행");
        }

        // 정적 메소드(Java 17부터 허용)
        static void method2() {
            System.out.println("D-method12실행");
        }
    }

    // 인스턴스 메소드
    void useD() {
        // D 객체 생성 및 인스턴스 필드 및 메소드 재사용
        D d = new D();
        System.out.println(d.field1);
        d.method1();

        // D 클래스의 정적 필드 및 메소드 사용
        System.out.println(D.field2);
        D.method2();
    }
}
