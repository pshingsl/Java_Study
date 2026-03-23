package NestedClass.C3;

public class AEx {
    public static void main(String[] args) {
        // A클래스의 B를 접근함 = A.B가 가능한 이유는 A 클래스에서 B를 정적 클래스로 선언해서 사용 가능
        A.B b = new A.B();
        b.methodB();
    }
}
