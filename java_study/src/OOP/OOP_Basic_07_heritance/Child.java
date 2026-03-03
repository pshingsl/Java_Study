package OOP.OOP_Basic_07_heritance;

public class Child extends Parent{
    // 필드선언
    public String filed2;

    // 오버라이딩
    @Override
    public void method2() {
        System.out.println("자식메소드2");
    }

    public void  method3(){
        System.out.println("자식메소드3");
    }
}
