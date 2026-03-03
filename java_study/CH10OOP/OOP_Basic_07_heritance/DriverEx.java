package OOP.OOP_Basic_07_heritance;

public class DriverEx {
    public static void main(String[] args) {
        Driver driver = new Driver();

        // 상속관계일 경우 사용 가능
        Bus bus = new Bus();
        driver.drive(bus);

        Taxi taxi = new Taxi();
        driver.drive(taxi);
    }
}
