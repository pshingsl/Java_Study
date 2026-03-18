package Lamda.C1;

// @FunctionalInterface 함수형 인터페이스 선언 -> 해당 추상 메서드가 없으면 에러 뜸 따라서 정의 필요
// abstract 생략 가능
@FunctionalInterface
public interface Calculable {

    void calculate(int x, int y);
}
