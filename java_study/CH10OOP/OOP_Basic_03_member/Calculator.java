package OOP.OOP_Basic_03_member;

public class Calculator {
    // 메서드는 객체의 동작 실행 블록에 정의 하는것
    void power() {
        System.out.println("전원을 킵니다.");
    }

    void poweOff() {
        System.out.println("전원을 끕니다.");
    }

    int add(int a, int b) {
        int result = a + b;
        return result;
    }

    double reactArea(double width, double height){
        return width * height;
    }
}
