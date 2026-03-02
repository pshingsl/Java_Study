package OOP.OOP_Basic_04_static;

public class Car {
    // 인스터늣 멤버: 객체에 속한 멤버(필드, 메서드)
    String model;
    int speed;

    Car(String model){
        this.model = model;
    }

    void setSpeed(int speed){
        this.speed = speed;
    }

    void run(){
        System.out.println(this.model + "가 달립니다.(시속" + this.speed + "km/h)");
    }
}
