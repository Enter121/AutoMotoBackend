package me.yaacob.core.model;

import jakarta.persistence.*;
import me.yaacob.core.model.car_parameters.CarColor;
import me.yaacob.core.model.car_parameters.FuelType;

@Entity
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    Car car;

    private int price;

    private FuelType fuelType;

    private CarColor carColor;

    private int mileage;

    private int year;

    private String vin;

    private String description;

    private String version;

    private int horsepower;

    private int doors;

    private int engineCapacity;

    private String phoneNumber;

    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
