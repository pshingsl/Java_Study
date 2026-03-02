package OOP.OOP_Basic_04_static;

public class Calculator {
    // 정적 멤버: 클래스 안에 있는 멤버(필드, 메서드)가 객체들 사이에 공유된다
    // static이 붙으며 인스턴스와 달리 객체를 생성 후 참조하는게 아닌 바로 클래스 자체로 접근할 수 있다
    static double Pi = 3.14;

    static int add(int a, int b) {
        return a + b;
    }
}
