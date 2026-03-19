package Lamda.C4;

public class Person {
    public void calc(Calcualble calcualble){
        double result = calcualble.calc(10, 4);
        System.out.println("결과: " + result);
    }
}
