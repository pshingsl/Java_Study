package Stream.CH03;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrStream {
    public static void main(String[] args) {
        String[] arr = {"Hyuk", "Hoo", "Aka"};
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(arrStr -> System.out.print(arrStr + " "));
        System.out.println();

        int[] arr2 = {1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(arr2);
        stream1.forEach(numArr -> System.out.print(numArr + " "));
    }
}
