package String;

public class StringIndexOfContainsEx {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍"; // 자바 프로그래밍 = 01234567

        int location = subject.indexOf("프로그래밍");
        System.out.println(location); // 3
        String subString = subject.substring(location);
        System.out.println(subString); //프로그래밍
        
        location = subject.indexOf("자바");
        if(location != -1){
            System.out.println("해당 글자가 존재합니다.");
        }else{
            System.out.println("해당 글자가 존재하지 않습니다.");
        }
        
        boolean result = subject.contains("자바");
        if (result){
            System.out.println("해당 글자가 존재함");
        }else{
            System.out.println("해당 글자 존재하지 않음");
        }
    }
}
