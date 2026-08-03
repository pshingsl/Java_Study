package OOP;

public class StaticClass {
    public static void main(String[] args) {
        /*
        * static
        *
        * 정의
        * ㄴ 객체를 생성하지 않아도 사용할 수 있는 클래스 소속의 멤버
        * ㄴ static 멤버는 클래스당 하나만 생성되어 모든 객체가 공유한다.
        *
        * 왜 사용하는가?
        * ㄴ 모든 객체가 하나의 데이터르 공유하기 위해
        * ㄴ 객체 생성 없이 사용할 기능을 만들기 위해
        * ㄴ 메모리 절약하기 위해
        *
        * 언제 사용하는가?
        * ㄴ 공통 데이터
        * ㄴ 유틸리티 클래스
        * ㄴ 상수
        * ㄴ 객체 개수 카운트
        * ㄴ 객체 생성 없이 사용하는 기능
        *
        * static이 없는 경우
        * ㄴ 메모리에 같은 데이터가 생성된다.
        *
        * static 변수
        * ㄴ 객체 생성이 필요 없다.
        *
        * 일반 메서드 static 메서드 차이
        * ㄴ 일반 메서드는 객체가 필요
        * ㄴ static 메서드는 객체 없이 호출 가능
        *
        * 제한
        * ㄴ static은 메서드 앞에 사용할 수 없다. -> static 메서드는 객체 없이 실행될 수 있기 떄문이다.
        * ㄴ 사용하라면 static 메서드 안에 객체 생성, static이 있는 클래스에서 변수 메서드에 static 사용
        *
        * static 블록
        * ㄴ 클래스가 처음 로딩 될 때 한 번만 실행 -> 객체가 여러 개 실행해도 한 번만 실행
        *
        * static 메모리에서 어떤 구조를 가지는가
        * ㄴ static 변수는 Method Area(클래스 메타데이터 영역)에 저장되어 클래스당 하나만 존재
        * ㄴ 객체의 일반 핃드는 Heap 영역에 객체마다 각각 저장
        *
        * 주의사항
        * ㄴ static은 객체가 아니라 클래스의 것이다.
        * ㄴ static 메서드는 일반 필드를 직접 사용 불가능
        * ㄴ static은 하나만 생성
        * ㄴ 공통 데이터 사용
        * */

        School school = new School();
        System.out.println(school);

        School.school();
        System.out.println(school.name);
    }
}
