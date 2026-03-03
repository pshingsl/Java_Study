package OOP.OOP_Basic_07_heritance;

public class SmartPhone2 extends Phone2{
    // 자식 생성자 선언

    public SmartPhone2(String model, String color) {
        // [순서 1] super(); 부모 생성자가 생략됨. 부모(Phone2)의 기본 생성자를 먼저 호출!
        // [순서 2] 부모로부터 물려받은 필드 초기화 및 자식 로직 실행
        // super();
        this.model = model;
        this.color = color;
        System.out.println("SmartPhone2(String mode, String color)");
    }
}
