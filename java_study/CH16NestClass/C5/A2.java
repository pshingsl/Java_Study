package NestedClass.C5;

public class A2 {
    // 인스턴스 필드
    String field = "A-field";

    // A 인스턴스 메소드
    void mehtod() {
        System.out.println("A-method");
    }

    // 인스턴스 멤버 클래스
    class B {
        // B 인스턴스 필드
        String field = "Bfield";

        // B 인스턴스 메서드
        void method() {
            System.out.println("B-method");
        }

        // B 인스턴스 메서드
        void print() {
            // B객체의 필드와 메소드 사용 -> 지금 필드와 메소드는 같은 이름을 가지고 있다.
            // 이를 구분하기위해 this를 사용한다. -> this 사용하면 해당 클래스의 내부에 생성한 필드와 메소드를 접근한다.
            // 지금은 자기 자신(B)를 구분하기 위해서 기본 this를 사용한다.
            System.out.println(this.field);
            this.method();

            // A2객체의 필드와 메소드 사용
            // 지금 B클래스의 메소드에서 A2의 필드와 메소드를 사용하려고한다.
            // 이떄 A2의 인스턴스 멤버를 사용하려면 A2의 객체를 생성 해야한다.
            // 하지만 이 방법 대신 this를 사용할 수 있다. -> 다른 클래스의 인스턴스 멤버를 사용하기 위해서 클래스명.this.인스턴스멤버로 선언
            // 일반 this로 사용하면 우리는 B에서 정의한 필드와 메소드를 먼저 찾게 된다.
            // 따라서 A2 클래스의 인스턴스 멤버를 사용하기 위해서 A2.this.A2인스턴스 멤버로 접근해야한다.
            System.out.println(A2.this.field);
            A2.this.mehtod();
        }
    }

    // A2의 인스턴스 메소드
    void useB(){
        B b = new B();
        b.print();
    }
}
