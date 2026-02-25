package Control;

public class IfElseIfEx {
    public static void main(String[] args) {
        int score = 90;

        if(score > 90){
            System.out.println("90보다 큽니다");
        } else if(score >= 90) {
            System.out.println("90이상 입니다");
        }else{
            System.out.println("90이하 입니다");
        }
    }
}
