package Array;

// 배열을 출력하는데 사용
import java.util.Arrays;

public class ArrCopy {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] tmp = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;

        System.out.println("arr: "+Arrays.toString(arr));
        System.out.println("tmp: " + Arrays.toString(tmp));

    }
}
