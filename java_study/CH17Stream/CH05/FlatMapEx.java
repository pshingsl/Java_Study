package Stream.CH05;

import NestedClass.C4.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("this is java");
        list.add("this is Spring");

        list.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(data -> System.out.println(data));
        System.out.println();

        List<String> list2 = Arrays.asList("1, 2, 3", "4, 5");
  
        list2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] arr = new int[strArr.length];
                    for(int i = 0; i < arr.length; i++){
                        arr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(arr);
                })
                .forEach(num -> System.out.println(num));
    }
}
