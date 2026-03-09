package Class.ObjectClass;

public class MemberEx {
    public static void main(String[] args) {
        Member obj1 = new Member("R");
        Member obj2 = new Member("R");

        System.out.println(obj1 == obj2);       // false
        System.out.println(obj1.equals(obj2));  // true -> Member클래스에서 eqauls()를 재정의해서 참 나옴
    }
}
