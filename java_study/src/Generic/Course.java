package Generic;

public class Course {

    // 와일드 카드는 매개변수 타입에 쓰거나 리턴타입에 쓸때에만 와일드 카드 사용가능
    public static void registerCourse1(Applicant<?> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "" +
                "이(가) Course1을 등록함");
    }

    // 학생 와일드 카드
    public static void registerCourse2(Applicant<? extends  Student> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "" +
                "이(가) Course2을 등록함");
    }

    // 직장인 와일드 카드 super를 사용해서 상위 타입도 사용가능
    public static void registerCourse3(Applicant<? super Worker> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "" +
                "이(가) Course3을 등록함");
    }
}
