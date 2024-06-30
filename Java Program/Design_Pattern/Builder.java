package Design_Pattern;

public class Builder {
    public static void main(String[] args) {
        Car car = new CarBuilder()
        .setName("Maruti")
        .setEngine("100CC")
        .setFuel("Petrol")
        .setSize("Hatchback")
        .build();

        System.out.println(car);
    }
}

class CarBuilder {
    private String name = null;
    private String engine = null;
    private String fuel = null;
    private String size = null;

    public CarBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public CarBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public Car build() {
        return new Car(name, engine, fuel, size);
    }
}

class Car {
    private String name = null;
    private String engine = null;
    private String fuel = null;
    private String size = null;

    public Car(String name, String engine, String fuel, String size) {
        this.name = name;
        this.engine = engine;
        this.fuel = fuel;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", engine=" + engine + ", fuel=" + fuel + ", size=" + size + "]";
    }
}
