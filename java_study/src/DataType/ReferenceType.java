package DataType;

public class ReferenceType {
    public static void main(String[] args) {
        /*
         * 참조형(referenec)
         * 객체의 주소(참조값)를 저장하는 데이터 타입이다.
         *
         * 대표적으로 클래스, 객체(Object), Enum, 배열(Array), 인터페이스, 컬렉션(List, Set, Map)
         *
         * 왜 사용하는가?
         * ㄴ 객체의 주소를 저장하고 여러 데이터를 하나로 관리하기 위해서이다.
         *
         * 언제 사용하는가?
         * ㄴ 문자열 저장, 배열 저장, 객체 저장, 리스트 저장
         *
         * 문법
         * ㄴ 클래스명 변수명 = new 클래스명(); or 문자열일땐 String str = "문자";
         *
         * 주의사항
         * 참조형은 null이 될 수 있다. null에서 메서드를 호출하면 NullPointerException 발생
         * */

        String str = "스프링";
        System.out.println(str);
        System.out.println(str.length());

        int[] arr = {1, 2, 3};
        System.out.println(arr.length);
    }
}
