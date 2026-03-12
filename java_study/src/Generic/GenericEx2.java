package Generic;

public class GenericEx2 {
    public static void main(String[] args) {
        Product<Tv, String> product1 = new Product<>();

        product1.setKind(new Tv());
        product1.setModel("Tv");

        Tv tv = product1.getKind();
        String model = product1.getModel();
        System.out.println(tv);
        System.out.println(model);
        System.out.println();

        Product<Car, String > product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("SUV");

        Car car = product2.getKind();
        String carModel = product2.getModel();
        System.out.println(car);
        System.out.println(carModel);


    }
}
