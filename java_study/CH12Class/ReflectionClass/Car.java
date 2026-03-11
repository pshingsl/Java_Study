package Class.ReflectionClass;

public class Car {
    // 필드
    private String model;
    private String owner;

    // 생성자
    public Car(String model, String owner) {
        this.model = model;
        this.owner = owner;
    }

    // 메소드
    public String getModel() {
        return model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
