package Lamda.C6;

public class MemberEx {
    public static void main(String[] args) {
        Person person = new Person();

        Member m1 = person.getMember1((id) -> {
            Member member = new Member(id);
            return member;
        });
        System.out.println(m1);

        m1 = person.getMember1((id) -> {
            return new Member(id);
        });
        System.out.println(m1);

        m1 = person.getMember1((id) -> new Member(id));
        System.out.println(m1);

        m1 = person.getMember1(Member::new);
        System.out.println(m1);
        System.out.println();

        Member m2 = person.getMember2((id, name) -> {
            Member member = new Member(id, name);
            return member;
        });
        System.out.println(m2);

        m2 = person.getMember2((id, name) -> {
            return new Member(id, name);
        });
        System.out.println(m2);

        m2 = person.getMember2((id, name) ->  new Member(id, name));
        System.out.println(m2);

        m2 = person.getMember2(Member::new);
        System.out.println(m2);
    }
}
