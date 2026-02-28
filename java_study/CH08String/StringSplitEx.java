package String;

import java.util.Arrays;

public class StringSplitEx {
    public static void main(String[] args) {
        String str = "자바, C, 파이썬, 자바스크립트";

        String[] strArr = str.split(",");
        System.out.println(Arrays.toString(strArr));

        for(String element : strArr){
            System.out.print(element + " ");
        }
    }
}
