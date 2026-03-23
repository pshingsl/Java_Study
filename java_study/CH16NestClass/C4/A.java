package NestedClass.C4;

public class A {
    // 생성자 안에서 생성된 로컬 클래스는 생성자 안에서만 사용 가능
    public A() {
        // 로컬 클래스
        class B {
        }

        // 로컬 객체 생성
        B b = new B();
    }

    // 메소드 안에서 생성된 로컬 클래스는 메소드 안에서만 사용 가능
    void method() {
        // 로컬 클래스 선언
        class B {

        }
        // 로컬 객체 생성
        B b = new B();
    }
}
