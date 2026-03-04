package OOP.OOP_Basic_08_interface;

public class DriverEx {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.run(bus);
        driver.run(taxi);
    }
}
