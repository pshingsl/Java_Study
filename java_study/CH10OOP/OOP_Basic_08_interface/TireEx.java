package OOP.OOP_Basic_08_interface;

public class TireEx {
    public static void main(String[] args) {
        Tire tire1 = new KoreaTIre();
        tire1.roll();
        System.out.println();

        Tire tire2 = new HyundaiTire();
        tire2.roll();
    }
}
