package OOP.OOP_Basic_07_heritance;

public class Cat extends Animal{
    @Override
    public void sound() {
        System.out.println("고양이는 야옹");
    }

    @Override
    public void run() {
        System.out.println("고양이는 걸읍니다.");
    }
}
