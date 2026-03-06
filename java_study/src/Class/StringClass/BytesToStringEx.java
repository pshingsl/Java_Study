package Class.StringClass;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BytesToStringEx {
    public static void main(String[] args) {

        String data = "자바";

        // 인코딩 -> 디코딩 또는 디코딩 -> 인코딩으로 변환할때 서로 같은 문자셋을 줘야만 올바른 문자열로 보건된다.
        try {
            // 인코딩(encoding): String -> byte[]
            byte[] arr = data.getBytes("UTF-8");

            System.out.println(arr.length); // 한글 한글자를 3바이트로 해석함 -> 총6바이트로 나옴
            System.out.println(Arrays.toString(arr)); // 자:-20, -98, -112, 바: -21, -80, -108

            // 디코딩(decoding): byte[] -> String
            String arr2 = new String(arr, "UTF-8");
            System.out.println(arr2);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
