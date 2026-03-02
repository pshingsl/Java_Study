package OOP.OOP_Basic_03_member;

public class CalculatorEx {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();

        c1.power();

        c1.poweOff();

        System.out.println(c1.add(1,3));

        System.out.println(c1.reactArea(10,3) + "cm입니다");
    }
}
