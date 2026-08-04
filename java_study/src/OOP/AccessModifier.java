package OOP;

import NestedClass.C4.A;

public class AccessModifier {
    public static void main(String[] args) {
        /*
         * 접근 제어자
         *
         * 정의
         * ㄴ 접근 제어자는 클래스, 변수, 메서드, 생성자에 대한 접근 범위를 제한하는 것아다
         * ㄴ 외부에서 마음대로 접근하지 못하도록 객체를 보호하는 것이다.
         *
         * 왜 사용하는가?
         * ㄴ 객체지향에서 가장 중요한 개념 중 하나가 캡슐화이다.
         * ㄴ 은행 계좌가 있다면 누구나 마음대로 금액을 출금할 수 있기 때문이다.
         * ㄴ 이런 상황을 막기위해 접근 제어자가 필요하다.
         *
         * 언제 사용하는가?
         * ㄴ 데이터를 숨기고 싶을 때
         * ㄴ 내부 구현을 보혹하고 싶을 때
         * ㄴ 외부에서 필요한 기능만 제공하고 싶을 때
         * ㄴ 객체지향 설계를 할 때
         *
         * 종류
         * ㄴ public -> 같은 클래스, 같은 패키지, 상속, 다른 패키지 범위 허용
         * ㄴ protected -> 같은 클래스, 같은 패키지, 상속 범위 허용 <-> 상속 허용 안함
         * ㄴ default -> 같은 클래스, 같은 패키지 범위 허용 <-> 상속, 다른 패키지 허용 안함
         * ㄴ private - > 같은 클래스만 허용
         *
         * 문법
         * 접근 제한자 class 클래스명 {}
         * 접근 제한자 자료형 변수명;
         * 접근제한자 자료형 메서드명;
         *
         * 주의사항
         * ㄴ public 남발 금지
         * ㄴ 대부분 private 사용
         * */

        Account account = new Account();

        account.deposit(50000);
        System.out.println(account.getBal());
    }
}

class Account {
    private int bal;

    public void deposit(int money) {
        bal += money;
    }

    public int getBal(){
        return bal;
    }
}
