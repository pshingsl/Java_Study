package OOP;

public class EncapsulationEx {
    public static void main(String[] args) {
        /*
        * 캡슐화(Encapsulation)
        *
        * 정읜
        * ㄴ 객체의 데이터(필드)를 외부에서 직접 접근하지 못하도록 숨긴다.
        * ㄴ 필요한 기능(메서드)만 외부에 공개하는 객체지향 설계 원칙
        * ㄴ 데이터는 숨기고, 기능만 공개하는 것
        * ㄴ private, Getter, Setter 이 세 가지를 함께 사용하여 구현
        *
        * 왜 사용하는가?
        * ㄴ 캡슐화를 사용하지 않으면 누구나 객체의 데이터 변경할 수 있다.
        *
        * 언제 사용하는가?
        * ㄴ 캡슐화는 거의 모든 클래스에서 사용한다.
        *
        * Getter
        * ㄴ 읽기 전용
        *
        * Setter
        * ㄴ 값 변경
        * ㄴ Setter는 비즈니스 메서드 사용하기 -> 아무 값이나 넣을 수 있기 떄문에 실무에서 잘 사용하지 않는다.
        *
        * 주의 사항
        * ㄴ public 금지
        * ㄴ private가 기본
        * ㄴ Getter는 많이 사용 -> 조회로 사용
        * ㄴ Setter는 최소화 -> 객체의 일관성을 깨뜨릴 수 있다.
        * ㄴ 데이터보다 행동을 공개 여기선 행동은 메서드
        * */

        Person person1 = new Person(-1, "");
        person1.getAge();
        person1.getName();

        Person person2 = new Person(20,"Huk");
        person2.getAge();
        person2.getName();
    }
}
