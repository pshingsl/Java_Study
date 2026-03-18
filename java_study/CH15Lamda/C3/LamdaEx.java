package Lamda.C3;

public class LamdaEx {
    public static void main(String[] args) {
        Person person = new Person();

        person.work((name, job) -> {
            System.out.print(name + "이 ");
            System.out.println(job + "을 합니다.");
        });

        person.speak((speak) -> System.out.println(speak + "라고 말합니다.0"));
    }
}
