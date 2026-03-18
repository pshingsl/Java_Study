package Lamda.C3;

public class Person {
    public void work(Workable workable){
        workable.work("Hyuk", "Student");
    }

    public void speak(Speakable speakable){
        speakable.speak("Hello");
    }
}
