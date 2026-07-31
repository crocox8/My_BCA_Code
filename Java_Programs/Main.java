// Assignment Question:
// Write a Java program to demonstrate inheritance and polymorphism by creating a 'Vehicle' class with subclasses 'Car', 'Motorcycle', and 'Truck'. The program should include methods to display vehicle details, calculate fuel efficiency, and compare vehicles based on their fuel efficiency.
// Author: Ansh Pandey

// Vehicle class
class Vehicle {
    private String brand;
    private String model;
    private double fuelCapacity;
    private double fuelConsumption;

    public Vehicle(String brand, String model, double fuelCapacity, double fuelConsumption) {
        this.brand = brand;
        this.model = model;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double calculateFuelEfficiency() {
        return this.fuelCapacity / this.fuelConsumption;
    }

    public void displayDetails() {
        System.out.println("Vehicle: " + brand + " " + model);
        System.out.println("Fuel Capacity: " + fuelCapacity + " litres");
        System.out.println("Fuel Consumption: " + fuelConsumption + " miles per litre");
    }
}

// Car class inherits from Vehicle
class Car extends Vehicle {
    private int numDoors;
    private double horsepower;

    public Car(String brand, String model, double fuelCapacity, double fuelConsumption, int numDoors, double horsepower) {
        super(brand, model, fuelCapacity, fuelConsumption);
        this.numDoors = numDoors;
        this.horsepower = horsepower;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsepower) {
        this.horsepower = horsepower;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numDoors);
        System.out.println("Horsepower: " + horsepower);
    }
}

// Motorcycle class inherits from Vehicle
class Motorcycle extends Vehicle {
    private int engineSize;
    private double weight;

    public Motorcycle(String brand, String model, double fuelCapacity, double fuelConsumption, int engineSize, double weight) {
        super(brand, model, fuelCapacity, fuelConsumption);
        this.engineSize = engineSize;
        this.weight = weight;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Size: " + engineSize);
        System.out.println("Weight: " + weight + " kg");
    }
}

// Truck class inherits from Vehicle
class Truck extends Vehicle {
    private int payloadCapacity;
    private double towingCapacity;

    public Truck(String brand, String model, double fuelCapacity, double fuelConsumption, int payloadCapacity, double towingCapacity) {
        super(brand, model, fuelCapacity, fuelConsumption);
        this.payloadCapacity = payloadCapacity;
        this.towingCapacity = towingCapacity;
    }

    public int getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(int payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    public double getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(double towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Payload Capacity: " + payloadCapacity + " kg");
        System.out.println("Towing Capacity: " + towingCapacity + " kg");
    }
}

public class Main {
    public static void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("Displaying Vehicle Details:");
        vehicle.displayDetails();
        System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency());
        System.out.println();
    }

    public static void compareVehicles(Vehicle vehicle1, Vehicle vehicle2) {
        double fuelEfficiency1 = vehicle1.calculateFuelEfficiency();
        double fuelEfficiency2 = vehicle2.calculateFuelEfficiency();

        if (fuelEfficiency1 > fuelEfficiency2) {
            System.out.println(vehicle1.getClass().getSimpleName() + " has better fuel efficiency than " + vehicle2.getClass().getSimpleName() + ": " + fuelEfficiency1 + " miles per litre vs " + fuelEfficiency2 + " miles per litre");
        } else if (fuelEfficiency2 > fuelEfficiency1) {
            System.out.println(vehicle2.getClass().getSimpleName() + " has better fuel efficiency than " + vehicle1.getClass().getSimpleName() + ": " + fuelEfficiency2 + " miles per litre vs " + fuelEfficiency1 + " miles per litre");
        } else {
            System.out.println(vehicle1.getClass().getSimpleName() + " and " + vehicle2.getClass().getSimpleName() + " have the same fuel efficiency: " + fuelEfficiency1 + " miles per litre");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 60, 20, 4, 200);
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Softail", 25, 10, 1800, 300);
        Truck truck = new Truck("Ford", "F-150", 100, 20, 1000, 3000);

        displayVehicleDetails(car);
        displayVehicleDetails(motorcycle);
        displayVehicleDetails(truck);

        compareVehicles(car, motorcycle);
        compareVehicles(motorcycle, truck);
        compareVehicles(truck, car);
    }
}

This code showcases polymorphism by allowing the `displayDetails` method to work with different subclasses of `Vehicle` and compares vehicles based on their fuel efficiency using the `compareVehicles` method.