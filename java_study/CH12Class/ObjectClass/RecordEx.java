package Class.ObjectClass;

public class RecordEx {
    public static void main(String[] args) {
        Person p = new Person("1", "Hyuk", 23);
        System.out.println(p.id());
        System.out.println(p.name());
        System.out.println(p.age());
        System.out.println(p.toString());
        System.out.println();

        Person p2 = new Person("1", "Hyuk", 23);
        System.out.println("p의 hashCode(): " + p.hashCode());
        System.out.println("p의 equals(p2): " + p.equals(p2));
    }
}
