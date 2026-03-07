package Class.WrapperClass;

public class ValueCompareEx {
    public static void main(String[] args) {
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println("==: " + (obj1 == obj2));
        System.out.println("equals(): " + obj1.equals(obj2));
        System.out.println();

        Integer o1 = 20;
        Integer o2 = 20;
        System.out.println("==: " + (o1 == o2));
        System.out.println("equals(): " + o1.equals(o2));
    }
}
