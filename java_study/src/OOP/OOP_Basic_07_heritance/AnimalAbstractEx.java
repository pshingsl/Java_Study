package OOP.OOP_Basic_07_heritance;

public class AnimalAbstractEx {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.run();

        Cat cat = new Cat();
        cat.sound();
        cat.run();
        // 매개변수 다형성
        animalSound(new Dog());
        animalSound(new Cat());
    }

    public static void animalSound(Animal animal) {
        animal.sound();
    }
}
