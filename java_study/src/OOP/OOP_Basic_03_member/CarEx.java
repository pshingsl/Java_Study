package OOP.OOP_Basic_03_member;

public class CarEx {
    public static void main(String[] args) {
        Car c1 = new Car(100, true, "Genesis");
        System.out.println("모델: " + c1.model);
        System.out.println("시동: " + c1.start);
        System.out.println("속도: " + c1.speed);
        System.out.println();

        Car c2 = new Car(false);
        System.out.println("모델: " + c2.model);
        System.out.println("시동: " + c2.start);
        System.out.println("속도: " + c2.speed);
        System.out.println();

        Car c3 = new Car(true, "Hyundai");
        System.out.println("모델: " + c3.model);
        System.out.println("시동: " + c3.start);
        System.out.println("속도: " + c3.speed);
        System.out.println();
    }
}
