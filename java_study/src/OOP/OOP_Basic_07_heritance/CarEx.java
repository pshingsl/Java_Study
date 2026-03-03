package OOP.OOP_Basic_07_heritance;

public class CarEx {
    public static void main(String[] args) {
        // 타이어
        Car c1 = new Car();
        // c1.run(); tire 필드가 아직 비어있기(null) 때문에 예외 발생
        c1.tire = new Tire();
        c1.run();

        // 금호
        c1.tire = new KumhoTire();
        c1.run();

        // 한국
        c1.tire = new KoreaTire();
        c1.run();
    }
}
