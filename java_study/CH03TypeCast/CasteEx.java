package TypeCast;

public class CasteEx {
    public static void main(String[] args) {
        int intVal = 10;
        byte byteVal = (byte)intVal;
        System.out.println("byteVal: " + byteVal);

        long longVal = 300;
        intVal = (int)longVal;
        System.out.println("intVal: " + intVal);

        intVal = 100;
        char charVal  = (char)intVal;
        System.out.println("charVal: " + charVal);

        double doubleVal = 3.14;
        intVal = (int)doubleVal;
        System.out.println("intVal: " + intVal);
    }
}
