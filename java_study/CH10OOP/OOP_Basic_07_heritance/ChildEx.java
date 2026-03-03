package OOP.OOP_Basic_07_heritance;

public class ChildEx {
    public static void main(String[] args) {
        Child c1= new Child();

        //자동타입 변환
        Parent parent = c1;

        // 메소드 호출
        parent.method1();
        parent.method2();
        // parent.method3(); 에러 발생 부모에는 메소드3이 없다.
        System.out.println();

        // 강제타입 변환
        Child c2 = (Child)parent;
        c2.filed2 = "필드2";
        c2.method3();
    }
}
