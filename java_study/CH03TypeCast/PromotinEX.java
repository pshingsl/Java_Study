package TypeCast;

public class PromotinEX {
    public static void main(String[] args) {
        byte byteVal  = 10;
        int intVal = byteVal;
        System.out.println("intVal: " + intVal);

        char charVal  = 'A';
        intVal = charVal;
        System.out.println("A의 유니코드: " + intVal);

        intVal = 50;
        long longVal = intVal;
        System.out.println("longVal: " + longVal);

        longVal = 152;
        float floatVal = longVal;
        System.out.println("floatVal: " + floatVal);

        floatVal = 100.4F;
        double doubuleVal  = floatVal;
        System.out.println("doubuleVal: " + doubuleVal);
    }
}
