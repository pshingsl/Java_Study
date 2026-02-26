package Array;

import java.util.Arrays;

public class ArrEqauls {
    public static void main(String[] args) {
        String[] arr1 = { "홍길동", "임꺽정", "박혁거세", "주몽", "고담덕" };
        String[] arr2 = { "홍길동", "임꺽정", "박혁거세", "주몽", "고담덕" };
        String[] arr3 = { "홍길동", "임꺽정", "박혁거세", "주몽" };

        System.out.println(Arrays.equals(arr1, arr2)); // true


        System.out.println(Arrays.equals(arr1, arr3)); // false
    }
}
