package DataType;

public class PrimitiveType {
    public static void main(String[] args) {
        /*
        * 기본형(Premitive Type)
        * 실제 값을 직접 저징하는 데이터 타입이다.
        * 총 8개가 존재한다.
        * ㄴ byte, short, int, long, float, double, char, boolean
        *
        * 왜 사용하는가?
        * ㄴ 메모리를 효유적으로 사용하고 값을 빠르게 계산하기 위해서이다.
        *
        * 언제 사용하는가?
        * 정수, 실수, 문자, 참/거짓을 표현할 떄 사용하낟.
        *
        * 문법
        * ㄴ 타입 변수명 = 값;
        *
        * 주의사항
        * ㄴ long은 L을 붙이는 습관을 들인다.
        * ㄴ float는 f를 붙인다.
        * ㄴ char은 작은 따옴표('')를 사용한다.
        * ㄴ String은 큰 따옴표("")를 사용한다.
        * */

        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4L;

        float e = 3.14f;
        double f = 3.14;

        char g = 'A';

        boolean h = true;

        System.out.println("byte: " + a);
        System.out.println("short: " + b);
        System.out.println("int: " + c);
        System.out.println("long: " + d);
        System.out.println("float: " + e);
        System.out.println("double: " + f);
        System.out.println("char: " + g);
        System.out.println("boolean: " + h);
    }
}
