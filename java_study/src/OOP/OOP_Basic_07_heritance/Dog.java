package OOP.OOP_Basic_07_heritance;

public class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("강아지는 멍멍");
    }

    @Override
    public void run() {
        System.out.println("강아지는 걸읍니다.");
    }
}
