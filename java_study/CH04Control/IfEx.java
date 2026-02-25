package Control;

public class IfEx {
    public static void main(String[] args) {
        int score = 93;

        if(score > 90){
            System.out.println("점수가 90보다 큽니다");
            System.out.println("A등급 입니다.");
        }

        if(score < 90) {
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("B등급 입니다."); // if문과 상관없이 실행함
        }
    }
}
