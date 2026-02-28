package String;

public class StringReplaceEx {
    public static void main(String[] args) {
        String originStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
        String newStr = originStr.replace("자바", "C언어");

        System.out.println(originStr);
        System.out.println(newStr);
    }
}
