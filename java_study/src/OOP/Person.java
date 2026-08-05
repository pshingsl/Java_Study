package OOP;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        if (age < 0) {
            System.out.println("0세는 될 수 없습니다.");
        }

        if (name.length() == 0) {
            System.out.println("이름은 0자가 될 수 없습니다.");
        }

        this.age = age;
        this.name = name;
    }

    public void getAge() {
        System.out.println(age);

    }

    public void getName() {
        System.out.println(name);
    }
}
