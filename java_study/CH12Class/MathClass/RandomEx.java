package Class.MathClass;

import java.util.Arrays;
import java.util.Random;

public class RandomEx {
    public static void main(String[] args) {
        //선택 번호
        int[] arr = new int[6];
        Random random = new Random(3);
        System.out.print("선택 번호: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(45) + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 당첨번호
        int[] winArr = new int[6];
        random = new Random(5);
        System.out.print("당첨번호: ");
        for (int i = 0; i < winArr.length; i++) {
            winArr[i] = random.nextInt(45) + 1;
            System.out.print(winArr[i] + " ");
        }
        System.out.println();

        // 당첨여부
        Arrays.sort(arr);
        Arrays.sort(winArr);
        boolean result = Arrays.equals(arr, winArr);
        System.out.print("당첨 여부: ");
        if(result){
            System.out.println("1등에 당첨되셨습니다.");
        }else{
            System.out.println("당첨되지 않았습니다.");
        }
    }
}
