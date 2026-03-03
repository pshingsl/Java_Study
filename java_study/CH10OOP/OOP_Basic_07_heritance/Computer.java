package OOP.OOP_Basic_07_heritance;

public class Computer extends Calculator{
    /* 메소드 오버라이딩
     * 메소드 오버라이딩을 하기 위해서 부모 클래스를 상속 받아야함 -> 부모 클래스의 메서드르 재정의함
     * 1. 선언부(리턴타입, 메소드명, 매개변수)가 같아야함
     * 2. 접근 제한자 범위를 좁힐 수 없다.
     * 3. 예새로운 예외를 추가로 throws 할 수 없다.
     */

    @Override
    public double areaCircle(double r) {
         // super.areaCircle(10); 부모 메소드 호출
        System.out.println("Computer 객체의 areaCircle()실행");
        return r * r * Math.PI;
    }
}
