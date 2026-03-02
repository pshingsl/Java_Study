package OOP.OOP_Basic_03_member;

public class Car {
    // 필드선언
    int speed;
    boolean start;
    String model;

    // 샡성자:new 연산자로 객체를 생성 후 객체를 초기화 역할을함
    // 클래스에서 생성자가 없으면 자바에서 자동으로 기본생성자를 만들어줌
    /*
     * 지금은 안 만들었지만 여기 Car클래스에서 자동으로 아래처럼 만들어짐
     * Car(){
     *
     * }
     * */

    Car(boolean start){
        this(400, start, "Per");
    }

    Car(boolean start, String model){
        this(500, start, model);
    }

    Car(int speed, boolean start, String model) {
        this.speed = speed;
        this.start = start;
        this.model = model;
    }
}
