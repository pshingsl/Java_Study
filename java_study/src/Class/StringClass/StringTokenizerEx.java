package Class.StringClass;

import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args) {
        String data1 = "Java&C,Python";
        String[] arr = data1.split("&|,");
        for(String token : arr){
            System.out.println(token);
        }
        System.out.println();

        String data2 = "Java,C,Python";
        StringTokenizer st = new StringTokenizer(data2, ",");
        while (st.hasMoreTokens()){
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
