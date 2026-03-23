package NestedClass.C3;

public class CEx {
    public static void main(String[] args) {
        // 클래스가 static D로 생성해서 new C.D(); 생성 가능
        C.D c = new C.D();
        System.out.println(c.field1);
        c.method1();

        System.out.println(C.D.field2);
        C.D.method2();
    }
}
