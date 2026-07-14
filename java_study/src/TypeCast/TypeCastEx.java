package TypeCast;

public class TypeCastEx {
    public static void main(String[] args) {
        /*
         * 형변환(Type cast)
         * 정의
         * ㄴ 한 데이터의 타입을 다른 데이터의 타입으로 변환하는 것
         *
         * 왜 사용하는가?
         * ㄴ 연산을 수행하거나 API가 요구하는 타입에 맞추기 위해 사용한다.
         *
         * 언제 사용하는가?
         * ㄴ 큰 타입 -> 작은 타입
         * ex) long -> int
         *
         * ㄴ 실수 -> 정수
         * ex) flaat -> int
         *
         * ㄴ 정수 -> 싫수
         * ex) int -> float
         *
         * 문법
         * 자동 형변환
         * int n = 10;
         * double v = n;
         *
         * 강제 형변환
         * double val = 10.1;
         * int nm = (int)val;
         *
         * 주의사항
         * ㄴ 자동 형변환: 작은 타입에서 큰 타입으로 변환 할 때 사용
         * ㄴ 강제 형변환: 데이터가 손실될 수 있다.
         *
         * 면접용
         * 자동 형변환: 작은 범위의 타입을 큰 타입으로 변환하며, 컴파일러가 자동으로 처리하고 데이터 손실이 없다.
         * 강제 형변환: 큰 범위 타입을 작은 타입으로 변화하며,
         * 개발자가 명시적으로 캐스팅하며, 값의 손싫이나 오버 플로우가 발생할 수 있다.
         * */

        int a = 10;
        double d = a;
        System.out.println("a: " + a);
        System.out.println("d: " + d);

        double c = 10.2;
        int changeInt = (int) c;
        System.out.println("c: " + c);
        System.out.println("changeInt: " + changeInt);

    }
}
