package TypeCast;

public class PrimitiveAndStringConversionEx {
    public static void main(String[] args) {
        int val1 = Integer.parseInt("10");
        double val2 = Double.parseDouble("10.25");
        boolean val3 = Boolean.parseBoolean("true");
        System.out.println("val1:" +val1);
        System.out.println("val2:" +val2);
        System.out.println("val3:" +val3);
        System.out.println();

        String strVal1 = String.valueOf(val1);
        String strVal2 = String.valueOf(val2);
        String strVal3 = String.valueOf(val3);
        System.out.println("strVal1:" +strVal1);
        System.out.println("strVal2:" +strVal2);
        System.out.println("strVal3:" +strVal3);

    }
}
