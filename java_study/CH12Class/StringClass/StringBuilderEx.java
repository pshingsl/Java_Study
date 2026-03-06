package Class.StringClass;

public class StringBuilderEx {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("자바")
                .insert(2, ", 스프링")
                .toString();
        System.out.println(data);


        StringBuilder sb = new StringBuilder();
        sb.append("DEF");
        sb.insert(0, "ABC");
        sb.delete(3, 4);
        sb.toString();
        System.out.println(sb);
    }
}
