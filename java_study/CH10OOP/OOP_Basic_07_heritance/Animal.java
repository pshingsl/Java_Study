package OOP.OOP_Basic_07_heritance;

public abstract class Animal {
    public void breathe() {
        System.out.println("숨을 쉽니다.");
    }

    // 추상 메소드 선언
    public abstract void sound();
}
