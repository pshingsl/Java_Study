package OOP.OOP_Basic_08_interface;

public interface Service {
    default void defaultMethod1() {
        System.out.println("디폴트 메소드1");
        defaultCommon();
    }

    default void defaultMethod2() {
        System.out.println("디폴트 메소드2");
        defaultCommon();
    }

    private void defaultCommon(){
        System.out.println("default메소드 중복코드 A");
        System.out.println("default메소드 중복코드 B");
    }

    static void staticMethod1(){
        System.out.println("static메서드 1");
        staticCommon();
    }

    static void staticMethod2(){
        System.out.println("static메서드 2");
        staticCommon();
    }

    private static void staticCommon() {
        System.out.println("static메소드 중복코드 C");
        System.out.println("static메소드 중복코드 D");
    }
}
