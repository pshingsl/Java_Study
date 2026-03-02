package OOP.OOP_Basic_05_encapsulation;

public class BikeEx {
    public static void main(String[] args) {
        Bike b1 = new Bike();
        System.out.println(b1.getSpeed());
        b1.setSpeed(-1);
        b1.setSpeed(10);
        System.out.println(b1.getSpeed());

        if(!b1.isStop()){
            b1.setStop(true);
        }

    }
}
