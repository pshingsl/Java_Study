package Generic;

public class GeneriicEx5 {
    // T는 숫자타입을 상속한 자식타입만 사용가능
    public static <T extends Number> boolean compare(T t1, T t2){
        // T의 타입을 출력
        System.out.println("compare(" + t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName() + ")");

        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        return (v1 == v2);
    }
    public static void main(String[] args) {
        boolean result1 =  compare(10, 20);
        System.out.println(result1);

        boolean result2 =  compare(4, 4);
        System.out.println(result2);
    }
}
