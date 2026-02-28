package String;

public class StringLengthEx {
    public static void main(String[] args) {
        String ssn = "0110253234567";
        int len = ssn.length();

        if(len == 13){
            System.out.println("주민등록번호 자릿수가 맞습니다.");
        }else{
            System.out.println("주민등록번호 자릿수가 틀립니다.");
        }
    }
}
