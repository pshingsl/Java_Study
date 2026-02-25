package Loop;

import java.util.Scanner;

public class BreakEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요.");
        System.out.println("해당 숫자가 12이면 프로그램은 종료가 됩니다.");

        for(int i =1; i<=100; i++){
            int n = sc.nextInt();
            if(n==12){
                System.out.println("해당 숫자: " + n);
                break;
            }
        }
    }
}
