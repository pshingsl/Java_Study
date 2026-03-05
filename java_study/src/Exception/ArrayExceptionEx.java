package Exception;

public class ArrayExceptionEx {
    public static void main(String[] args) {
        String[] arr = {"100", "1oo", null, "2000"};

        for (int i = 0; i <= arr.length; i++) {
            try {
                System.out.println(arr[i]);
                int value = Integer.parseInt(arr[i]);
            } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                System.out.println("문자열이 없거나 항목수가 부족합니다. 다시 확인해주세요");
            } catch (NumberFormatException e) {
                System.out.println("숫자로 변환할 수 없는  항목이 존재. 다시 확인 해주세요.");
            } catch (Exception e) {
                System.out.println("예상치 못한 예외가 발생했습니다.");
            }
        }
    }
}
