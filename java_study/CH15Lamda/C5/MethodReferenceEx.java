package Lamda.C5;

public class MethodReferenceEx {
    public static void main(String[] args) {
        Person person = new Person();
        // 정적 메소드일 경우(Person)
        // 람다식
        person.action((x, y) -> Computer.staticMethod(x, y));

        // 메서드 참조
        person.action(Computer::staticMethod);
        System.out.println();

        // 인스턴스 메서드 일 경우(Computer)
        Computer computer = new Computer();
        // 람다식
        person.action((x, y) -> computer.instanceMethod(x, y));
        // 메서드 참조
        person.action(computer::instanceMethod);
        System.out.println();

        // 비교(compare) 매개변수의 메소드 참조
        // 26 ~ 32 메소드는 같은 결과가 나오는데 아래로 갈 수 록 짧게 작성하려고 함
        Person p = new Person();

        p.ordering((a, b) -> {
            return a.compareToIgnoreCase(b);
        });

        p.ordering((a, b) -> a.compareToIgnoreCase(b));

        p.ordering(String::compareToIgnoreCase);
    }
}
