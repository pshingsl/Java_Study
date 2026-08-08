package OOP;

public class FinalExam {
    public static void main(String[] args) {
        /*
         * final
         *
         * 정의
         * ㄴ 한 번 결정된 것을 다시 변경하지 못하도록 제한하는 키워드
         * ㄴ 변수, 메서드, 클래스 앞에 사용 가능
         * ㄴ 변수: 값을 다시 대입 할 수 없음
         * ㄴ 메서드: 자식 클래스에서 오버라이딩할 수 없음
         * ㄴ 클래스: 상속할 수 없다.
         *
         * 왜 사용하는가?
         * ㄴ 프로그램에서 변경 안 되는 값이나 기능을 보호하기 위해서이다.
         * ㄴ 원주율 등등
         *
         * 언제 사용하는가?
         * ㄴ 상수, 변경되면 안되는 변수, 상속을 막아야 하는 클래스, 메서드의 재정의를 막아야 하는 경우
         *
         *주의사항
         * ㄴ final은 객체 불변은 아니다. -> 변수의 재할당을 막는 것이지 객체 내부까지 자동으로 불변으로 만드는 것이 아니다.
         * ㄴ final 필드는 초기화가 필요하다 -> final로 선언해도 생성자 등에서 반드시 값을 한 번 지정해야 한다.
         * ㄴ statia fianl은 상수 -> 변경되지 않는 클래스 수준의 상수
         * */
    }
}

class User1 {
    public static final String DEFAULT_ROLE = "USER";

    private final Long userId;

    private String name;

    public User1(Long userId, String name) {
        this.name = name;
        this.userId = userId;
    }

    public Long getUserId(){
        return userId;
    }

    public void changeName(String name){
        this.name = name;
    }
}
