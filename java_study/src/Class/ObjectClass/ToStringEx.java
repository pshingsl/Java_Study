package Class.ObjectClass;

public class ToStringEx {
    public static void main(String[] args) {
        SmartPhone sm  = new SmartPhone("삼성", "안드로이드");

        String strObj = sm.toString();
        System.out.println(strObj); // toString() 메소드 호출

        System.out.println(sm);     // toString() 메소드 호출
    }
}
