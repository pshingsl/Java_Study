package Loop;

import java.util.Scanner;

public class DoWhileEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("메세지를 입력하세요.");
        System.out.println("프로그램 종료하려면 q를 눌러주세요.");

        String input;
        do{
            input = sc.nextLine();
            System.out.println(input);
        }while (!input.equals("q"));
        System.out.println();
        System.out.println("프로그램 종료");
    }
}
