// src/main/java/Vehicle.java
public abstract class Vehicle {
    public abstract void park();
    public String type;
}

public class Motorcycle extends Vehicle {
    public Motorcycle() { type = "Motorcycle"; }
    @Override
    public void park() {
        System.out.println("Parking a motorcycle.");
    }
}

public class Car extends Vehicle {
    public Car() { type = "Car"; }
    @Override
    public void park() {
        System.out.println("Parking a car.");
    }
}

public class Bus extends Vehicle {
    public Bus() { type = "Bus"; }
    @Override
    public void park() {
        System.out.println("Parking a bus.");
    }
}
