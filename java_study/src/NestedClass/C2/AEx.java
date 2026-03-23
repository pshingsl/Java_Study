package NestedClass.C2;

public class AEx {
    public static void main(String[] args) {
        // A 객체 생성
        A a =  new A();
        a.num=10;

        // B객체 생성
        A.B b = a.new B();
        b.method1();
    }
}
