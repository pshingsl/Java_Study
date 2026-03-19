package Lamda.C5;

public class Person {
    public void action(Calcuable calcuable) {
        double result = calcuable.calc(10, 4);
        System.out.println("결과: " + result);
    }

    public void ordering(Comparable comparable) {
        String a = "Hyuk";
        String b = "Hoon";

        int result = comparable.compare(a, b);

        // 숫자로 비교하는 이유는 두 매개변수를 비교하는 것을 정수형 변수로 선언해서
        if (result < 0){
            System.out.println(a+"은 " + b +"보다 앞에 옵니다.");
        } else if(result == 0){
            System.out.println(a+"은 " + b +"과 같습니다.");
        }else {
            System.out.println(a+"은 " + b +"보다 뒤에 옵니다.");
        }
    }
}
