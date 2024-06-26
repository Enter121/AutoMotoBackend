package me.yaacob.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import me.yaacob.core.dto.ArticleDTO;
import me.yaacob.core.model.car_parameters.CarColor;
import me.yaacob.core.model.car_parameters.FuelType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="articles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    Car car;

    @OneToMany(cascade = CascadeType.ALL)
    List<ImagePackage> imageList;

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

    public Article() {
    }

    public Article(List<ImagePackage> imageList, Long id, Car car, int price, FuelType fuelType, CarColor carColor, int mileage, int year, String vin, String description, String version, int horsepower, int doors, int engineCapacity, String phoneNumber, String author) {
        this.imageList=imageList;
        this.id = id;
        this.car = car;
        this.price = price;
        this.fuelType = fuelType;
        this.carColor = carColor;
        this.mileage = mileage;
        this.year = year;
        this.vin = vin;
        this.description = description;
        this.version = version;
        this.horsepower = horsepower;
        this.doors = doors;
        this.engineCapacity = engineCapacity;
        this.phoneNumber = phoneNumber;
        this.author = author;
    }

    public List<ImagePackage> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImagePackage> imageList) {
        this.imageList = imageList;
    }

    public void addImage(ImagePackage imagePackage) {
        this.imageList.add(imagePackage);
    }

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

    public void update(ArticleDTO dto){
        if(dto.getBrand()!=null) {
            this.car.setBrand(dto.getBrand());
        }
        if(dto.getModel()!=null) {
            this.car.setModel(dto.getModel());
        }
        if(dto.getType()!=null) {
            this.car.setType(dto.getType());
        }
        if(dto.getPrice()!=0){
        this.price = dto.getPrice();
        }
        if(dto.getFuelType()!=null) {
            this.fuelType = dto.getFuelType();
        }
        if(dto.getCarColor()!=null) {
            this.carColor = dto.getCarColor();
        }
        if(dto.getMileage()!=0) {
            this.mileage = dto.getMileage();
        }
        if(dto.getYear()!=0) {
            this.year = dto.getYear();
        }
        if(dto.getVin()!=null) {
            this.vin = dto.getVin();
        }
        if(dto.getDescription()!=null) {
            this.description = dto.getDescription();
        }
        if(dto.getVersion()!=null) {
            this.version = dto.getVersion();
        }
        if(dto.getHorsepower()!=0) {
            this.horsepower = dto.getHorsepower();
        }
        if(dto.getDoors()!=0) {
            this.doors = dto.getDoors();
        }
        if(dto.getEngineCapacity()!=0) {
            this.engineCapacity = dto.getEngineCapacity();
        }
        if(dto.getPhoneNumber()!=null) {
            this.phoneNumber = dto.getPhoneNumber();
        }
        if(dto.getAuthor()!=null) {
            this.author = dto.getAuthor();
        }
    }

}
