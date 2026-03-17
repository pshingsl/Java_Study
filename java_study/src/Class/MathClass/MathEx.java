package Class.MathClass;

public class MathEx {
    public static void main(String[] args) {
        // 큰 정수 또는 작은 정수 얻기
        double v1 = Math.ceil(5.3);
        double v2 = Math.floor(5.3);
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);

        // 큰 값 또는 작은값 얻기
        long v3 = Math.max(3, 7);
        long v4 = Math.min(3, 7);
        System.out.println("v3: " + v3);
        System.out.println("v4: " + v4);

        double tmp = 12.561;
        double tmp1 = tmp * 100;
        long temp = Math.round(tmp1);
        double v5 = temp / 100.0;
        System.out.println("v5: " + v5);
    }
}
