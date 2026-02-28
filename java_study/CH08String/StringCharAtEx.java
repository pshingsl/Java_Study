package String;

public class StringCharAtEx {
    public static void main(String[] args) {
        String str = "자바 프로그래밍";
        char ch1 = str.charAt(1);

        switch (ch1) {
            case '자':
                System.out.println("글자 자입니다.");
                break;
            case '바':
                System.out.println("글자 바입니다.");
                break;
            default:
                System.out.println("해당 글자가 없습니다.");
        }
        System.out.println();
        
        String ssn = "0110253234567";
        char sex = ssn.charAt(6);
        
        switch(sex){
            case '1':
            case '3':
                System.out.println("남자입니다.");
                break;
            case '2':
            case '4':
                System.out.println("여자입니다.");
                break;    
        }
    }
}
