package OOP;

public class ObjectInstanceExam {
    public static void main(String[] args) {
        /*
        * 객체와 인스턴스
        *
        * 정의
        * ㄴ 객체: 클래스를 기반으로 실제 메모리에 생성된 실체
        * ㄴ 인스턴스: 특정 클래스로 부터 생성된 객체를 의미
        *
        * 왜 사용하는가?
        * ㄴ 클래스는 설계도 일 뿐 실제 데이터를 저장하지 못한다.
        * ㄴ 실제 데이터를 저장하고 기능을 사용하려면 객체를 생성해야 한다.
        *
        * 언제 사용하는가?
        * ㄴ 클래스를 실제로 사용할 떄마다 객체를 생성한다.
        * ㄴ 회원 가입, 공연 등록, 결제 생성 등등
        *
        * 문법(객체 생성)
        * ㄴ 클래스명 변수명 = new 클래스명(); -> 여기서 변수명은 참조변수라고 한다.
        *
        * 객체 생성 과정
        * 1. JVM이 Heap 메모리에 클래스의 객체를 생성
        * 2. 생성된 객체의 주소를 반환
        * 3. 주소를 클래스 변수(Stack)에 저장
        * 4. 클래스를 통해 Heap의 객체를 참조
        *
        * stack: 참조 변수 저장
        * Heap:: 실제 객체 저장
        *
        * 주의사항
        * ㄴ 객체와 참조 변수를 혼동하지 말기 -> 객체: Heap, 클래스 -> stack
        * ㄴ new를 사용해야 객체가 생성된다.
        * ㄴ 참조 변수끼리 대입하면 객체가 복사되지 않는다. -> 객체는 하나이고 참조 변수만 하나 더 생긴다.
        * ㄴ null 객체 접근 금지 -> 예외발생
        * */

        OOPStuendent stuendent = new OOPStuendent();
        stuendent.name = "Hyuk";
        stuendent.age = 20;

        System.out.println(stuendent.name);
        System.out.println(stuendent.age);
    }
}

class OOPStuendent {
    int age;
    String name;
}