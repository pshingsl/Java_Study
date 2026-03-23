package NestedClass.C5;

public class A {
    // A의 인스턴스 필드와 메소드
    int field1;
    void method1(){}

    // A의 정적 필드와 메소드
    static int field2;
    static void method2() {}

    // 인스턴스 멤버 클래스
    // 중첩 클래스가 인스턴스 멤버 클래스일 경우 바깥 클래스의 모든 필드와 메소드 접근 가능
    // 중첨 클래스가 정적 멤버 클래스일 경우 바깥 클래스의 정적 필드와 정적 메소드 접근 가능
    class B {
        void mehtod(){
            // A의 인스턴스 필드와 메소드 사용
            field1 = 10;
            method1();

            // A의 정적 필드와 메소드 사용
            field2 = 20;
            method2();
        }
    }

    // 정적 멤버 클래스
    static class C{
        void method1(){
            // A의 인스턴스 필드와 메소드 사용
            //field1 = 10; xx A객체가 없어서 에러 발생
            //method1(); xx A객체가 없어서 에러 발생
            A a = new A();
            a.field1 = 20;
            // A의 정적 필드와 메소드 사용
            // A는 static 선언이 되므로 객체 생성없이 사용가능하다.
            // 따라서 아래 filed2, method2()는 정적 멤버 클래스 안에서 사용이 가능하다.
            field2 = 10;
            method2();
        }
    }
}
