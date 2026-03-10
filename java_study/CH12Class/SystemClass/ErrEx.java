package Class.SystemClass;

public class ErrEx {
    public static void main(String[] args) {
        try{
            int val = Integer.parseInt("1oo");
        }catch (NumberFormatException e){
            System.out.println("에러내용");
            System.out.println(e.getMessage());
        }
    }
}
