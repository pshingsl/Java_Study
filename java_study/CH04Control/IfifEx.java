package Control;

import java.util.Scanner;

public class IfifEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        System.out.println("나이를 입력해주세요:"  + age);
        if(age >= 25) {
            if(age < 30){
                System.out.println("당신은 20대 중후반입니다.");
            } else{
                System.out.println("당신은 30대 이상입니다");
            }
        }else{
            System.out.println("당신의 25보다 작습니다.");
        }
    }
}
