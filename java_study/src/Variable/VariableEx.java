package Variable;

public class VariableEx {
    public static void main(String[] args) {
        /*
        * 정수 타입
        * 가장 기본이 되는 숫자를 저장하는 방식
        * */
        System.out.println("정수 타입");
        int birthYear = 2001;
        int birthMonth = 10;
        int birthDay = 25;
        System.out.println("생년월일: " + birthYear +"년 "+ birthMonth +"월 " + birthDay + "일");
        System.out.println();

        /*
        * 문자타입: 하나의 문자를 작은 따옴펴(' ')로 감싼 것을 문자 리터럴이다
        * 문자 리터럴은 유니코드로 변환되어 저장
        * 특징: 유니코드가 정수이므로 char 타입도 정수 타입에 속한다.
        * */
        System.out.println("정수 타입(문자)");
        char c1 = 'A'; // 'A: 문자와 매칭되는 숫자 65로 대입
        char c2 = '가'; // '가' 문자와 매칭되는 숫자:44032로 대입
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println();

        /*
        * 소수를 나타날떄 사용
        * double의 경우는 변수의 값을 소수로 저장하면 알아서 double 타입으로 인지한다
        * float의 경우는 'f' or 'F"를 붙여야 컴일러가 float 타입임을 알 수 있다.
        * */
        System.out.println("실수 타입");
        double d1 = 3.14592;
        float f1 = 5.1482f;
        System.out.println("d1: " + d1);
        System.out.println("f2: " + f1);
        System.out.println();

        /*
        * 논리타입
        * 논리타입은 참과 거짓을 의미하는 리터럴이다
        * true또는 false의 값을 가진다.
        * 주로 두 가지 상태값을 저장할 필요가 있는경우에 사용되며, 조건문과 제어문의 실행 흐름을 변경하는데 사용
        * */
        System.out.println("논리 타입");
        int x = 10;
        boolean re1 = x>10;
        boolean re2 = 9<x;
        System.out.println("re1: " + re1);
        System.out.println("re2: " + re2);
        System.out.println();

        /*
        * 문자열 티입
        * char터압의 문자를 여러개를 합친것이다
        * 큰따옴표("")로 감싼 여러 개의 문자들은 유니코드로 변환 되지 않는다.
        * String타입으로 시작된다.
        * */
        System.out.println("문자열 타입");
        String name  = "Hyuk";
        String job = "백엔드 취업 준비생";
        System.out.println(name);
        System.out.println(job);
        System.out.println(name + " " + job +"입니다");

    }
}
