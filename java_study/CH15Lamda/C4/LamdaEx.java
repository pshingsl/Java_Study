package Lamda.C4;

import Lamda.C4.Person;

public class LamdaEx {
    public static void main(String[] args) {
        Person person = new Person();

        person.calc((x, y) -> {
            double result = x + y;
            return result;
        });

        person.calc((x, y) -> x + y);

        person.calc((x, y) -> minus(x, y));
    }

    public static double minus(double x, double y) {
        return x - y;
    }
}
