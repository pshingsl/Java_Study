package Lamda.C6;

public class Member {
    String id;
    String name;

    public Member(String id) {
        this.id = id;
        System.out.println(" Member(String id)");
    }

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Member(String id, String name)");
    }

    @Override
    public String toString() {
        String info = "{id: " + id + ", " + "name: " + name + "}";
        return info;
    }
}
