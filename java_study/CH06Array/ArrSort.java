package Array;

import java.util.Arrays;
import java.util.Collections;

public class ArrSort {
    public static void main(String[] args) {
        // 반복문을 사용해서 정렬
        int[] arr = {4, 9, 1, 4, 3, 2, 6, 5, 7, 8};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("arr: " + Arrays.toString(arr));

        // 메서드을 사용해서 정렬
        int[] arr2 = {4, 9, 1, 4, 3, 2, 6, 5, 7, 8};
        Arrays.sort(arr2);
        System.out.println("arr2: " + Arrays.toString(arr2));

        // 역정렬
        Integer[] arr3 = {4, 9, 1, 4, 3, 2, 6, 5, 7, 8};
        Arrays.sort(arr3, Collections.reverseOrder());
        System.out.println("arr3: " + Arrays.toString(arr3));

        // 역정렬 반복문(버블 정렬)
        int arr4[] = {4, 9, 1, 4, 3, 2, 6, 5, 7, 8};

        // [1단계] 큰 반복문: "총 몇 번의 라운드를 돌 것인가?"
        // 배열 원소가 10개라면, 9번만 제대로 줄 세우면 마지막 하나는 자동으로 정해집니다.
        for (int i = 0; i < arr4.length - 1; i++) {

            // [2단계] 작은 반복문: "실제로 옆 친구와 키를 비교해서 자리를 바꾸는 과정"
            // j < arr4.length - 1 - i 인 이유:
            // 1. '- 1': j와 j+1을 비교할 때, 마지막 칸에서 옆 칸(넘어가는 칸)을 보지 않기 위해!
            // 2. '- i': 라운드(i)가 지날수록 뒤쪽은 이미 정렬이 끝났으니 더 볼 필요가 없어서!
            for (int j = 0; j < arr4.length - 1 - i; j++) {

                // [3단계] 비교와 교체: "작은 놈은 뒤로 가!" (내림차순)
                // 왼쪽(j)이 오른쪽(j+1)보다 작다면 자리를 바꿉니다.
                if (arr4[j] < arr4[j + 1]) {
                    // [4단계] 스왑(Swap): 컵 두 개의 내용물 바꾸기 (tmp 활용)
                    int tmp = arr4[j];       // 1. 왼쪽 값을 임시 보관함에 저장
                    arr4[j] = arr4[j + 1];    // 2. 오른쪽 값을 왼쪽 칸으로 복사
                    arr4[j + 1] = tmp;        // 3. 보관함에 있던 값을 오른쪽 칸에 넣기
                }
            }
            // 한 라운드(i)가 끝날 때마다 가장 작은 숫자가 맨 뒤로 배달됩니다.
        }

        System.out.println("arr4: " + Arrays.toString(arr4));
    }
}
