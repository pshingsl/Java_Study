package String;

public class StringEqaulsEx {
    public static void main(String[] args) {
        String val = "자바";
        String val2 = "자바";

        if (val == val2) {
            System.out.println("val과 val2은 참조가 같음");
        } else {
            System.out.println("val과 val2은 참조가 다름");
        }

        String val3 = new String("자바");
        String val4 = new String("자바");

        if (val3 == val4) {
            System.out.println("val3과 val4은 참조가 같음");
        } else {
            System.out.println("val3과 val4은 참조가 다름");
        }

        if (val == val3) {
            System.out.println("val과 val3은 참조가 같음");
        } else {
            System.out.println("val과 val3은 참조가 다름");
        }

        if (val3.equals(val4)) {
            System.out.println("val3과 val4은 참조가 같음");
        }

        if (val2.equals(val4)) {
            System.out.println("val2과 val4은 참조가 같음");
        }
    }
}
