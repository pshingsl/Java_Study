package NestedClass.C2;

/*
* 클래스에는 필드, 생성자, 메소드, 중첩 클래스를 만들 수 있다.
* 중첩 클래스는 필드, 생성자, 메소드을 만들 수 있다.
* */
public class A {
    int num;

    // 인스턴스 멤버 클래스 생성
    class B{
        // 필드 생성자 메소드 생성 가능
        void method1(){
            System.out.println("methodB() 실행");
        }
    }

    // 인스턴스 필드 값으로 B 객체 대입
    // A클래스이 타입이 B인 field 필드 객체 생성
    B field = new B();

    // 생성자
    A() {
        B b = new B();
    }

    // 인스턴스 메소드
    void method(){
        B b = new B();
    }
}
