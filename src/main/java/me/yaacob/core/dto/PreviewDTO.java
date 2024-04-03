package me.yaacob.core.dto;


import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import me.yaacob.core.model.Article;
import me.yaacob.core.model.Car;
import me.yaacob.core.model.car_parameters.FuelType;

public class PreviewDTO {

    public PreviewDTO(Long articleId, Car car, int price, FuelType fuelType, int year, int mileage) {
        this.articleId = articleId;
        this.price = price;
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.fuelType = fuelType;
        this.year = year;
        this.mileage = mileage;
    }

    public PreviewDTO() {
    }

    private Long articleId;

    private String brand;

    private String model;

    private int price;

    private FuelType fuelType;

    private int year;

    private int mileage;


    public static PreviewDTO map(Article article){
        return new PreviewDTO(article.getId(),article.getCar(),article.getPrice(),article.getFuelType(),article.getYear(),article.getMileage());
    }


    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
