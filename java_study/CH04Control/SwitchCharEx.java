package Control;

public class SwitchCharEx {
    public static void main(String[] args) {
        char grade = 'B';

        switch (grade){
            case 'A':
            case 'a':
                System.out.println("상위 등급입니다.");
                break;
            case 'B':
            case 'b':
                System.out.println("중간 등급입니다.");
                break;
            case 'C':
            case 'c':
                System.out.println("하위 등급입니다.");
                break;
            default:
                System.out.println("최하위 입니다.");
        }
    }
}
