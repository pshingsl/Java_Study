package OOP.OOP_Basic_02_class;

public class SportCarEx {
    public static void main(String[] args) {
        // SportCar 객체 생성
        SportCar s1 = new SportCar(); // 참조타입 SportCar s1변수 선언 -> SportCar의 기능 사용 가능

        System.out.println(s1.color); // null
        System.out.println(s1.start); // false
        System.out.println(s1.tire);  // 0
    }
}
