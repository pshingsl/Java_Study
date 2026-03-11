package Class.ReflectionClass;

public class GetClassEx {
    public static void main(String[] args) {
        // 패키지 이름
        Class  clazz = Car.class;

        System.out.println("패키지:" + clazz.getPackage().getName());
        System.out.println("패키지2:" + clazz.getPackageName()); // 7~8은 같은 것이다.
        System.out.println("클래스 간단 이름:" + clazz.getSimpleName());
        System.out.println("클래스 전체 이름:" + clazz.getName());
    }
}
