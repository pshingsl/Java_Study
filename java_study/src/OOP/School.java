package OOP;

public class School {
    String name = "school";

    static String school = "static school";

    
    static {
        System.out.println("클래스 로딩");
    }
    
    static void school() {
        System.out.println(school + " 테스트");
    }
}
