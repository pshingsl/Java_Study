package Class.WrapperClass;

public class BoxingUnBoxingEx {
    public static void main(String[] args) {
        // Boxing
        Integer obj = 100;
        System.out.println("Value: " + obj.intValue());
        Integer o1 = new Integer(200);
        System.out.println("o1: " + o1);

        // UnBoxing
        int value = obj;
        System.out.println("value: " + value);

        // 연산 시 UnBoxing
        int result  = obj + 100;
        System.out.println("result: " + result);
    }
}
