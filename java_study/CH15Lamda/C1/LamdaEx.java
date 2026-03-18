package Lamda.C1;

public class LamdaEx {
    public static void main(String[] args) {
        action((x, y) -> {
            int result  = x + y;
        System.out.println("result: " + result);
        });

        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }

    // 데이터 처리부 생성
    public static void action(Calculable calculable) {
        int x  = 20;
        int y = 10;

        // 데이터 처리
        calculable.calculate(x, y);
    }
}
