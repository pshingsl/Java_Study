package Class.RegexpClass;

import java.util.regex.Pattern;

public class PatternEx {
    public static void main(String[] args) {
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-1234-5678";
        boolean result = Pattern.matches(regExp, data);
        if(result){
            System.out.println("정규식과 일치합니다");
        }else{
            System.out.println("정규식과 일치하지 않습니다");
        }

        regExp = "\\w+@\\.\\w+(\\.\\w+)?";
        data = "w455ok@naver.com";
        result = Pattern.matches(regExp, data);
        if(result){
            System.out.println("정규식과 일치합니다");
        }else{
            System.out.println("정규식과 일치하지 않습니다");
        }
    }
}
