package String;

public class StringSubStringEx {
    public static void main(String[] args) {
        String ssn = "011025-3234567";

        String firstNum = ssn.substring(0, 6); // 0 <= x < 6
        System.out.println(firstNum);

        String secondNum = ssn.substring(7); // 7번재 이후 모드 문자열 출력
        System.out.println(secondNum);
    }
}
