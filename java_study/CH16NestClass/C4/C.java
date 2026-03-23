package NestedClass.C4;

public class C {
    // 메소드
    public void mehtod1(int arg) {
        // 로컬변수(생성자 또는 메소드의 매개변수 또는 내부안에서 선언된 변수)
        int val = 1;

        // 로컬 클래스(메소드 또는 생성자 안에서 선언된 클래스)
        class D {
            // 메소드
            void method2() {
                // 로컬 변수 읽기
                System.out.println("arg: " + arg);
                System.out.println("val: " + val);

                // 로컬 변수 수정
                // val = 2; 내부 클래스 내에서 final또는 유사 final로 인식이 되어서 수정 시 에러가 남
                // arg = 2; 내부 클래스 내에서 final또는 유사 final로 인식이 되어서 수정 시 에러가 남
            }
        }

        // 로컬 객체 생성
        D d = new D();
        // 로컬 객체 메소드 호출
        d.method2();

        // 로컬 변수 수정
        // val = 3; 내부 클래스 내에서 final또는 유사 final로 인식이 되어서 수정 시 에러가 남
        // arg = 3; 내부 클래스 내에서 final또는 유사 final로 인식이 되어서 수정 시 에러가 남
    }
}
