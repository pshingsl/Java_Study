package Lamda.C5;

public class Computer {
    // Caclcuable에서 만든 메서드의 매개변수의 개수와 매개변수 타입이 똑같아야한다
    // 만약 다르면 메인 함수에서 타입 및 개수가 다르다고 에러가 나온다.
    public static double staticMethod(double x, double y){
        return x + y;
    }

    public double instanceMethod(double x, double y){
        return  x * y ;
    }
}
