package OOP.OOP_Basic_07_heritance;

public class InstacneofEx {
    public static void VehicleInfo(Vehicle vehicle){
        vehicle.run();

        if(vehicle instanceof  Taxi taxi){
            System.out.println("택시는 비클에 소속됩니다.");
        }
    }
    public static void main(String[] args) {
       Vehicle v1 = new Vehicle();
       VehicleInfo(v1);

       Vehicle v2 = new Taxi();
        VehicleInfo(v2);
    }
}
