package Control;

public class SwitchExpression {
    public static void main(String[] args) {
        /*
         * switch Expression
         * Java14부터 정식 도입되었으며, Java17에서도 사용하는 최신 switch문법
         *
         * 정의
         * ㄴ 기존 Switch문의 단점을 개선한 새로운 Switch문이다.
         * ㄴ 기존과 달리 값을 반환하는 표현식이다.
         *
         * 왜 사용하는가?
         *ㄴ 1. break을 빼먹기 쉽다. -> 다른 case들도 실행됨
         *ㄴ 2. 값을 반환하지 못한다.
         *ㄴ 3. 코드가 길어진다.
         *
         * 언제 사용하는가?
         *ㄴ switch의 결과를 하나의 값으로 만들어야 할 때 사용한다.
         * ㄴ 등급 계산, 상태 문자열 변환, 메뉴선택 등등
         *
         * 문법
         * ㄴ 데이터타입 변수 = switch(값) {
         *
         *                       case 값1 -> 결과1;
         *
         *                       case 값2 -> 결과2;
         *
         *                       case 값3 -> 결과3;
         * };
         *
         * 주의사항
         * ㄴ break을 사용하지 않는다.
         * ㄴ 여러 줄은 yield사용
         * ㄴ default를 반드시 작성하는 것이 좋다.
         * ㄴ 자바 14이상에서 사용
         * */

        int score = 50;

        String grade = switch (score) {

            case 100, 90 -> "A";

            case 80 -> "B";

            case 70 -> "C";

            default -> "F";
        };

        System.out.println(grade);

        score = 100;

        String result = switch (score) {
            case 100 -> {
                System.out.println("Perfect");
                yield "A+";
            }
            default -> "F";
        };
        System.out.println(result);
    }
}
